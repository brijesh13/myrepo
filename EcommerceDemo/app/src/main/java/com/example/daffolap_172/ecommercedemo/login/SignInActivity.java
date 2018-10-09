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
import com.example.daffolap_172.ecommercedemo.home.HomeActivity;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class SignInActivity extends AppCompatActivity {

    private TextView forgot_password,login,new_user,signup,skip;
    private EditText email_id,password;
    private ProgressDialog progressDialog;
    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in);
        progressDialog =new ProgressDialog(this);
        login=findViewById(R.id.login);
        forgot_password=findViewById(R.id.forgot_password);
        new_user=findViewById(R.id.new_user);
        signup=findViewById(R.id.signup_here);
        skip=findViewById(R.id.btn_skip);
        email_id=findViewById(R.id.email_id);
        password=findViewById(R.id.password);
        mAuth = FirebaseAuth.getInstance();
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String email=email_id.getText().toString();

                String pass=password.getText().toString();

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
        forgot_password.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(SignInActivity.this,ForgotPassActivity.class);
                startActivity(intent);
            }
        });
        new_user.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(SignInActivity.this,SignUpActivity.class);
                startActivity(intent);
            }
        });
        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(SignInActivity.this,SignUpActivity.class);
                startActivity(intent);
            }
        });
        skip.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(SignInActivity.this,HomeActivity.class);
                startActivity(intent);

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
                            Intent intent=new Intent(SignInActivity.this,HomeActivity.class);
                            startActivity(intent);
                            Toast.makeText(SignInActivity.this,"Sign in Successful",Toast.LENGTH_SHORT).show();
                        } else {
                            // If sign in fails, display a message to the user.
                            progressDialog.hide();

                            Toast.makeText(SignInActivity.this,"you got some error",Toast.LENGTH_SHORT).show();
                        }
                    }
                });

    }
}
