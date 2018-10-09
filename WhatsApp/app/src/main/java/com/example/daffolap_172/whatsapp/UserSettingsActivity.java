package com.example.daffolap_172.whatsapp;

import android.app.ProgressDialog;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.firebase.ui.storage.images.FirebaseImageLoader;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;
import com.squareup.picasso.Picasso;
import com.theartofdev.edmodo.cropper.CropImage;
import com.theartofdev.edmodo.cropper.CropImageView;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

import de.hdodenhof.circleimageview.CircleImageView;
import id.zelory.compressor.Compressor;

public class UserSettingsActivity extends AppCompatActivity {


    FirebaseFirestore db;
    private FirebaseAuth mAuth;
    private FirebaseUser firebaseUser;

    private CircleImageView mDisplayImage;
    private TextView mName;
    private TextView mstatus;
    private static int GALLERY_PICK=1;
    private Button mStatusBtn;
    private Button mImageChange;
    DocumentReference docRef;
    private ProgressDialog mProgressDialog;
    //Storage Firebase

    private StorageReference mImageStorage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_settings);

        mDisplayImage = (CircleImageView) findViewById(R.id.profile_image);
        mName = (TextView) findViewById(R.id.setting_name);
        mStatusBtn = (Button) findViewById(R.id.status_change);
        mImageChange = (Button) findViewById(R.id.profile_change);
        Log.i("MMMMMMMM", mName + "");
        mstatus = (TextView) findViewById(R.id.default_setting);
        mImageStorage = FirebaseStorage.getInstance().getReference();
        firebaseUser = mAuth.getInstance().getCurrentUser();
        db = FirebaseFirestore.getInstance();
        String uid = firebaseUser.getUid();
        Log.i("Id", uid);
        docRef = db.collection("users").document(uid);
        docRef.get().addOnCompleteListener(new OnCompleteListener<DocumentSnapshot>() {
            @Override
            public void onComplete(@NonNull Task<DocumentSnapshot> task) {
                if (task.isSuccessful()) {
                    DocumentSnapshot document = task.getResult();
                    if (document.exists()) {
                        String name = document.getString("name");
                        String image = document.getString("image");

                        String status = document.getString("status");

                        //String thums_image=document.getString("thums_image");

                        mName.setText(name);
                        mstatus.setText(status);
                        /*Picasso.get().load(Uri.parse(image)).into(mDisplayImage);*/
                        if(!image.equals("defualt")){
                        Glide.with(getApplicationContext()/* context */)
                                .using(new FirebaseImageLoader())
                                .load(FirebaseStorage.getInstance().getReference(image))
                                .into(mDisplayImage);}

                        Log.i("DocumentSnapshot data: ", mName + "");
                    } else {
                        Log.i("aaaaaaaaa", "No such document");
                    }
                } else {
                    Log.i("get failed with ", String.valueOf(task.getException()));
                }
            }
        });

        mStatusBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(UserSettingsActivity.this, StatusActivity.class);
                startActivity(intent);

            }
        });
        mImageChange.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                CropImage.activity()
//                        .setGuidelines(CropImageView.Guidelines.ON)
//                        .start(UserSettingsActivity.this);

                Intent galleryIntent = new Intent();

                galleryIntent.setType("image/*");

                galleryIntent.setAction(Intent.ACTION_GET_CONTENT);

                startActivityForResult(Intent.createChooser(galleryIntent, "Select Image"), GALLERY_PICK);

            }
        });

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode==GALLERY_PICK && resultCode==RESULT_OK)
        {
            Uri imageUri=data.getData();
            CropImage.activity(imageUri)
                    .setAspectRatio(1,1)
                    .start(this);

        }
        if (requestCode == CropImage.CROP_IMAGE_ACTIVITY_REQUEST_CODE) {

            CropImage.ActivityResult result = CropImage.getActivityResult(data);

            if (resultCode == RESULT_OK) {
                mProgressDialog =new ProgressDialog(UserSettingsActivity.this);

                mProgressDialog.setTitle("Uploding Image");

                mProgressDialog.setMessage("Please wait while we upload and process image");

                mProgressDialog.setCanceledOnTouchOutside(false);

                mProgressDialog.show();

                Uri resultUri = result.getUri();
                Bitmap thumb_bitmap = null;


                File thumb_path=new File(resultUri.getPath());

                try {
                    thumb_bitmap = new Compressor(this)
                            .setMaxWidth(200)
                            .setMaxHeight(200)
                            .setQuality(75)
                            .compressToBitmap(thumb_path);

                } catch (IOException e) {
                    e.printStackTrace();
                }
                ByteArrayOutputStream baos = new ByteArrayOutputStream();
                thumb_bitmap.compress(Bitmap.CompressFormat.JPEG, 100, baos);
                final byte[] thumb_byte = baos.toByteArray();


                String mCurrentUser =firebaseUser.getUid();


                final StorageReference filePath=mImageStorage.child("profile_images").child(mCurrentUser +".jpg");
                final StorageReference thumb_filePath=mImageStorage.child("profile_images").child("thumbs").child(mCurrentUser+".jpg");
                filePath.putFile(resultUri).addOnCompleteListener(new OnCompleteListener<UploadTask.TaskSnapshot>() {

                    @Override
                    public void onComplete(@NonNull Task<UploadTask.TaskSnapshot> task) {
                        if(task.isSuccessful())
                        {
                           /*String downloadUrl= task.getResult().toString();*/
                            final String downloadUrl= filePath.getPath();/*.getDownloadUrl().toString();*/

                            UploadTask uploadTask=thumb_filePath.putBytes(thumb_byte);

                            uploadTask.addOnCompleteListener(new OnCompleteListener<UploadTask.TaskSnapshot>() {
                                @Override
                                public void onComplete(@NonNull Task<UploadTask.TaskSnapshot> thumb_task) {
                                    String thumb_image_download=thumb_filePath.getPath();
                                    if(thumb_task.isSuccessful())
                                    {
                                        Map update_hashmap=new HashMap<>();

                                        update_hashmap.put("image",downloadUrl);
                                        update_hashmap.put("thumb_image",thumb_image_download);
                                        docRef.update(update_hashmap).addOnCompleteListener(new OnCompleteListener<Void>() {
                                            @Override
                                            public void onComplete(@NonNull Task<Void> task) {
                                                if(task.isSuccessful())
                                                {

                                                    mProgressDialog.dismiss();
                                                    Toast.makeText(UserSettingsActivity.this,"Success uploading",Toast.LENGTH_LONG).show();
                                                }
                                                else
                                                {

                                                }
                                            }
                                        });
                                    }
                                    else {
                                        Toast.makeText(UserSettingsActivity.this,"Error while uploding thumb_image",Toast.LENGTH_LONG).show();
                                        mProgressDialog.dismiss();
                                    }

                                }
                            });

                        }
                        else {
                            Toast.makeText(UserSettingsActivity.this,"Error while uploding",Toast.LENGTH_LONG).show();
                            mProgressDialog.dismiss();
                        }
                    }
                });

            } else if (resultCode == CropImage.CROP_IMAGE_ACTIVITY_RESULT_ERROR_CODE) {

                Exception error = result.getError();
            }
        }
    }

    public static String random() {
        Random generator = new Random();
        StringBuilder randomStringBuilder = new StringBuilder();
        int randomLength = generator.nextInt(10);
        char tempChar;
        for (int i = 0; i < randomLength; i++){
            tempChar = (char) (generator.nextInt(96) + 32);
            randomStringBuilder.append(tempChar);
        }
        return randomStringBuilder.toString();
    }
}
