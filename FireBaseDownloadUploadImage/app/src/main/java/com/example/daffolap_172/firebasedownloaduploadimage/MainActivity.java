package com.example.daffolap_172.firebasedownloaduploadimage;

import android.graphics.Bitmap;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.storage.FileDownloadTask;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;

import java.io.File;
import java.io.IOException;

public class MainActivity extends AppCompatActivity {

    private StorageReference mStorageRef;
    private ImageView imageContainer;
    private TextView overlayText;
    private EditText editText;
    private Button uploadButton;
    private ProgressBar progressBar;
    private TextView downloadUrl;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imageContainer =findViewById(R.id.imageContainer);

        overlayText.setText("");

        overlayText.setVisibility(View.INVISIBLE);

        editText =(EditText) findViewById(R.id.editText);

        editText.addTextChangedListener(new InputTextWatcher());
        uploadButton =findViewById(R.id.upload_Button);
        uploadButton.setOnClickListener(new UploadOnClickListener());
        progressBar=(ProgressBar)findViewById(R.id.progress_Bar);
        progressBar.setVisibility(View.GONE);
        downloadUrl =(TextView) findViewById(R.id.download_Url);


    }


    class UploadOnClickListener implements View.OnClickListener {


        @Override
        public void onClick(View view) {

            imageContainer.setDrawingCacheEnabled(true);
            Bitmap bitmap=new
        }
    }
}

