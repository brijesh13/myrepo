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

public class MainActivity extends AppCompatActivity implements ViewInterface {

    private EditText mEmail_id,password;
    private TextView mLogin,mSignup;
    private ProgressDialog progressDialog;
    private PresenterClass mPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mEmail_id=findViewById(R.id.email_id);
        password=findViewById(R.id.password);
        mLogin=findViewById(R.id.login);
        mSignup=findViewById(R.id.signup_here);
        progressDialog=new ProgressDialog(this);
        mLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String email=mEmail_id.getText().toString();
                String pass=password.getText().toString();
                if(!TextUtils.isEmpty(email)||!TextUtils.isEmpty(pass))
                {
                    progressDialog.setTitle(" Login.........");

                    progressDialog.setMessage("Please wait while we login your account");

                    progressDialog.setCanceledOnTouchOutside(false);

                    progressDialog.show();

                    mPresenter=new PresenterClass(getApplicationContext(),email,pass);
                    boolean flag=mPresenter.login();
                    if(flag==true)
                    {   progressDialog.dismiss();
                        onSuccess();
                    }

                    else {
                        progressDialog.dismiss();
                        onFailure();
                    }
                }
                else
                {
                    Toast.makeText(MainActivity.this, "please enter valid email and password", Toast.LENGTH_SHORT).show();
                }

            }
        });
        mSignup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(MainActivity.this,SignupActivity.class);
                startActivity(intent);

            }
        });
    }

    @Override
    public void onSuccess() {
        Intent intent=new Intent(this,HomeActivity.class);
        startActivity(intent);
        Toast.makeText(this, "you have login successfuly", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onFailure() {
        Intent intent=new Intent(this,MainActivity.class);
        startActivity(intent);
        Toast.makeText(this, "you got some error", Toast.LENGTH_SHORT).show();
    }
}
