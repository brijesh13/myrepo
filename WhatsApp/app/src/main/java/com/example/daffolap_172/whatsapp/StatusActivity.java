package com.example.daffolap_172.whatsapp;

import android.annotation.SuppressLint;
import android.app.ProgressDialog;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.Gallery;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.firestore.FirebaseFirestore;

import static com.google.android.gms.flags.FlagSource.G;

public class StatusActivity extends AppCompatActivity {

    private Toolbar mToolbar;
    ProgressDialog mProgressDialog;
    private TextInputLayout mStatus;
    private Button mSaveBtn;


    //Firebase
    private DatabaseReference mDatabaseRef;
    private FirebaseUser mCurrentUser;
    FirebaseFirestore db;
    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_status);
        //Firebase
        mCurrentUser = FirebaseAuth.getInstance().getCurrentUser();
        final String uid=mCurrentUser.getUid();
        db= FirebaseFirestore.getInstance();

        mToolbar=(Toolbar) findViewById(R.id.status);

        setSupportActionBar(mToolbar);

        getSupportActionBar().setTitle("Account Status");

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        mStatus =(TextInputLayout)findViewById(R.id.status_input);


        mSaveBtn =(Button)findViewById(R.id.update_button);

        mSaveBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //progress
                mProgressDialog =new ProgressDialog(StatusActivity.this);
                mProgressDialog.setTitle("Save Changes");
                mProgressDialog.setMessage("Please wait while we save changes");
                mProgressDialog.show();

                String status=mStatus.getEditText().getText().toString();

                db.collection("users").document(uid).update("status",status).addOnCompleteListener(new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {
                        if(task.isSuccessful())
                        {

                            mProgressDialog.dismiss();
                        }
                        else
                        {
                            Toast.makeText(getApplicationContext(),"there was some error",Toast.LENGTH_LONG).show();
                        }
                    }
                });
            }
        });



    }
}
