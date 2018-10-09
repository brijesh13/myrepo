package com.example.daffolap_172.whatsapp;

import android.app.ProgressDialog;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;

public class RegisterActivity extends AppCompatActivity {

    private TextInputLayout mDispalyName;

    private TextInputLayout mEmail;

    private TextInputLayout mPass;

    private Button createAccount;

    private FirebaseAuth mAuth;

    private Toolbar toolbar;
    FirebaseFirestore db;

    private DatabaseReference databaseReference;
    private FirebaseDatabase firebaseDatabase;

    private ProgressDialog progressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        progressDialog =new ProgressDialog(this);

        toolbar =(Toolbar) findViewById(R.id.register_page);

        setSupportActionBar(toolbar);

        getSupportActionBar().setTitle("Create Account");

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        mAuth = FirebaseAuth.getInstance();
        db= FirebaseFirestore.getInstance();

        mDispalyName= findViewById(R.id.displayName);

        mEmail= findViewById(R.id.email);

        mPass = findViewById(R.id.pass);

        createAccount= findViewById(R.id.createAccount);

        DatabaseReference databaseReference;

        createAccount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String mName=mDispalyName.getEditText().getText().toString();

                String email=mEmail.getEditText().getText().toString();

                String pass=mPass.getEditText().getText().toString();

                if(!TextUtils.isEmpty(mName) || !TextUtils.isEmpty(email)||!TextUtils.isEmpty(pass))
                {
                    progressDialog.setTitle("Registering User");

                    progressDialog.setMessage("Please wait while we create your account");

                    progressDialog.setCanceledOnTouchOutside(false);

                    progressDialog.show();

                    register(mName,email,pass);
                }



            }
        });
    }

    public void register(final String name, String email, String pass)
    {
     mAuth.createUserWithEmailAndPassword(email,pass).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
         @Override
         public void onComplete(@NonNull Task<AuthResult> task) {
             if(task.isSuccessful())
           {
               FirebaseUser firebaseUser=mAuth.getInstance().getCurrentUser();

               String uid=firebaseUser.getUid();


               //DatabaseReference database = FirebaseDatabase.getInstance().getReferenceFromUrl("XXXXXXXXX");
               //databaseReference= firebaseDatabase.getReference().getRef().child("Users").child(uid);

               HashMap<String,String> userMap=new HashMap<>();

               userMap.put("name",name);
               userMap.put("status","Hi i am using whatsapp");
               userMap.put("image","defualt");
               userMap.put("thums_image","defualt");
              // db.child("Users").child(uid).setValue(userMap);

               db.collection("users").document(uid)
                       .set(userMap).addOnCompleteListener(new OnCompleteListener<Void>() {
                   @Override
                   public void onComplete(@NonNull Task<Void> task) {
                       if(task.isSuccessful())
                       {

                           progressDialog.dismiss();

                           Intent intent=new Intent(RegisterActivity.this,MainActivity.class);
                           intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);

                           startActivity(intent);
                       }
                   }
               });
                       /*.addOnCompleteListener(new OnCompleteListener<DocumentReference>() {
                   @Override
                   public void onComplete(@NonNull Task<DocumentReference> task) {
                       if(task.isSuccessful())
                       {

                           progressDialog.dismiss();

                           Intent intent=new Intent(RegisterActivity.this,MainActivity.class);
                           intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);

                           startActivity(intent);
                       }
                   }
               });*/


             }
             else {
                 progressDialog.hide();

                 Toast.makeText(RegisterActivity.this,"you got some error",Toast.LENGTH_SHORT).show();
             }
         }
     });
    }
}
