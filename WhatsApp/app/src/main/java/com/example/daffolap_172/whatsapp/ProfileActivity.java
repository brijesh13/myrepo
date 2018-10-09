package com.example.daffolap_172.whatsapp;

import android.app.ProgressDialog;
import android.media.Image;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.firebase.ui.storage.images.FirebaseImageLoader;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.storage.FirebaseStorage;
import com.squareup.picasso.Picasso;

import java.util.HashMap;


public class ProfileActivity extends AppCompatActivity {
    private ImageView imageView;
    private TextView mProfileName,mProfileStatus,mProfileFriendsCount;
    private Button mProfileRequestSendBtn;
    private ProgressDialog mProgressBar;
    private CollectionReference mFriendReuestDatabase;
    private FirebaseFirestore mUserDatabase;
    private FirebaseAuth mAuth;
    private String mCurrent_Status;
    private CollectionReference mUser_Database;
    String uid;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        mProfileName =(TextView)findViewById(R.id.profile_name);
        mProfileStatus=(TextView)findViewById(R.id.profile_display_status);
        mProfileFriendsCount=(TextView)findViewById(R.id.profile_friends_count);
        mProfileRequestSendBtn=(Button)findViewById(R.id.send_friend_request_btn);
        mProfileName.setText(getIntent().getStringExtra("name"));
        mProfileStatus.setText(getIntent().getStringExtra("status"));
        imageView=findViewById(R.id.profile_image_view);
        //firestore database
        final FirebaseUser firebaseUser=mAuth.getInstance().getCurrentUser();

        uid=firebaseUser.getUid();
        Log.i("Id",uid);

        mFriendReuestDatabase=FirebaseFirestore.getInstance().collection("Friend_Request");

        mUser_Database=FirebaseFirestore.getInstance().collection("users");

        mCurrent_Status="not_Friends";
        mProgressBar=new ProgressDialog(this);
        mProgressBar.setMessage("Loading All Users");
        mProgressBar.setMessage("Please wait while we load the user data");
        mProgressBar.setCanceledOnTouchOutside(true);
        mProgressBar.show();
        Glide.with(this)
                .using(new FirebaseImageLoader())
                .load(FirebaseStorage.getInstance().getReference(getIntent().getStringExtra("image")))
                .placeholder(R.drawable.dp)
                .into(imageView);
        mProgressBar.dismiss();

        mProfileRequestSendBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(mCurrent_Status.equals("not_Friends"))
                { final String u=getIntent().getStringExtra("user_id");
                    HashMap<String,String> userMap1=new HashMap<>();
                    final HashMap<String,String> userMap2=new HashMap<>();
                    userMap1.put("request_type","sent");
                    userMap1.put("receiver_id",u);
                    userMap2.put("request_type","received");
                    userMap2.put("sender_id",uid);
                    mFriendReuestDatabase.document(uid).set(userMap1).addOnCompleteListener(new OnCompleteListener<Void>()
                         {
                        @Override
                        public void onComplete(@NonNull Task<Void> task) {
                            if(task.isSuccessful())
                            {
                                mFriendReuestDatabase.document(u).set(userMap2)
                                        .addOnCompleteListener(new OnCompleteListener<Void>() {
                                            @Override
                                            public void onComplete(@NonNull Task<Void> task) {
                                                if(task.isSuccessful())
                                                {
                                                    Toast.makeText(ProfileActivity.this, "Request Sent Succesfully", Toast.LENGTH_SHORT).show();
                                                }
                                            }
                                        });
                            }
                            else {
                                Toast.makeText(ProfileActivity.this, "Failed Request Sending", Toast.LENGTH_SHORT).show();
                            }

                        }
                    });

                }
            }
        });
    }
}
