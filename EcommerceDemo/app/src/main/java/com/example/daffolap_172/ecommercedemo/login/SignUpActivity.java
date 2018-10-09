package com.example.daffolap_172.ecommercedemo.login;

import android.app.ProgressDialog;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.daffolap_172.ecommercedemo.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import java.util.HashMap;

public class SignUpActivity extends AppCompatActivity {
    private ProgressDialog progressDialog;
    private EditText name ,email_id,password;
    private TextView sign_up;
    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        progressDialog=new ProgressDialog(this);
        name=findViewById(R.id.name);
        email_id=findViewById(R.id.email_id);
        password=findViewById(R.id.password);
        sign_up=findViewById(R.id.signup);
        mAuth = FirebaseAuth.getInstance();
        sign_up.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name_str=name.getText().toString();

                String email_str=email_id.getText().toString();

                String pass=password.getText().toString();

                if(!TextUtils.isEmpty(name_str) || !TextUtils.isEmpty(email_str)||!TextUtils.isEmpty(pass))
                {
                    progressDialog.setTitle("Registering User");

                    progressDialog.setMessage("Please wait while we create your account");

                    progressDialog.setCanceledOnTouchOutside(false);

                    progressDialog.show();

                    register(name_str,email_str,pass);
                }
            }
        });

    }
    public void register(final String name, String email, String pass)
    {
        mAuth.createUserWithEmailAndPassword(email, pass)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if(task.isSuccessful())
                {
                       progressDialog.dismiss();
                    Toast.makeText(SignUpActivity.this,"Sign Up Successful",Toast.LENGTH_SHORT).show();
                }
                else {
                    progressDialog.hide();

                    Toast.makeText(SignUpActivity.this,"you got some error",Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
