package com.example.daffolap_172.whatsapp;

import android.app.ProgressDialog;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class login extends AppCompatActivity {

    private TextInputLayout mDispalyName;

    private TextInputLayout mEmail;

    private TextInputLayout mPass;

    private Button login;

    private FirebaseAuth mAuth;

    private Toolbar toolbar;

    private ProgressDialog progressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        progressDialog =new ProgressDialog(this);

        toolbar =(Toolbar) findViewById(R.id.login_page);

        setSupportActionBar(toolbar);

        getSupportActionBar().setTitle("Login");

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        mAuth = FirebaseAuth.getInstance();

        mEmail= findViewById(R.id.email);

        mPass = findViewById(R.id.password);

        login= findViewById(R.id.loginButton);

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String email=mEmail.getEditText().getText().toString();

                String pass=mPass.getEditText().getText().toString();

                if(!TextUtils.isEmpty(email)||!TextUtils.isEmpty(pass))
                {
                    progressDialog.setTitle(" Login.........");

                    progressDialog.setMessage("Please wait while we login your account");

                    progressDialog.setCanceledOnTouchOutside(false);

                    progressDialog.show();

                    login(email,pass);
                }
            }
        });
    }

    public void login(String email,String pass)
    {
        mAuth.signInWithEmailAndPassword(email, pass)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            // Sign in success, update UI with the signed-in user's information
                            progressDialog.dismiss();

                            Intent intent=new Intent(login.this,MainActivity.class);

                            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);

                            startActivity(intent);
                        } else {
                            // If sign in fails, display a message to the user.

                            progressDialog.hide();

                            Toast.makeText(login.this,"you got some error",Toast.LENGTH_SHORT).show();
                        }

                        // ...
                    }
                });

    }
}
