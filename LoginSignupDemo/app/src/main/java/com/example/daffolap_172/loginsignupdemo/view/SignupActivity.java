package com.example.daffolap_172.loginsignupdemo.view;

import android.app.ProgressDialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.daffolap_172.loginsignupdemo.R;
import com.example.daffolap_172.loginsignupdemo.presenter.PresenterClass;

public class SignupActivity extends AppCompatActivity implements ViewInterface{
    private EditText mUser_name,mEmail,password;
    private TextView mSignup;
    private ProgressDialog progressDialog;
    private PresenterClass mPresenter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);
        mUser_name=findViewById(R.id.user_name);
        mEmail=findViewById(R.id.email_id);
        password=findViewById(R.id.password);
        mSignup=findViewById(R.id.signup_here);
        progressDialog=new ProgressDialog(this);
        mSignup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name=mUser_name.getText().toString();
                String email=mEmail.getText().toString();
                String pass=password.getText().toString();
                if(!TextUtils.isEmpty(email)||!TextUtils.isEmpty(pass))
                {
                    progressDialog.setTitle(" Login.........");

                    progressDialog.setMessage("Please wait while we Signup your account");

                    progressDialog.setCanceledOnTouchOutside(false);

                    progressDialog.show();

                    mPresenter=new PresenterClass(getApplicationContext(),name,email,pass);
                    boolean flag=mPresenter.signup();
                    if(flag==true)
                    {   progressDialog.dismiss();
                        onSuccess();
                    }
                    else
                    {   progressDialog.dismiss();
                        onFailure();
                    }
                }
                else
                {
                    Toast.makeText(SignupActivity.this, "please enter all required fields", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    @Override
    public void onSuccess() {
        Intent intent=new Intent(this,MainActivity.class);
        startActivity(intent);
        Toast.makeText(this, "you have signup successfuly", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onFailure() {
        Intent intent=new Intent(this,SignupActivity.class);
        startActivity(intent);
        Toast.makeText(this, "you have got successfuly", Toast.LENGTH_SHORT).show();
    }
}
