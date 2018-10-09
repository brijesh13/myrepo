package com.example.daffolap_172.mvpdemo.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.daffolap_172.mvpdemo.R;
import com.example.daffolap_172.mvpdemo.model.LoginModel;
import com.example.daffolap_172.mvpdemo.presenter.PresenterInterface;
import com.example.daffolap_172.mvpdemo.view.ViewIneterface;

public class MainActivity extends AppCompatActivity implements ViewIneterface {

    EditText mUser,mPass;
    Button mLogin;
    PresenterInterface mPresenterInterface;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mUser=findViewById(R.id.username);
        mPass=findViewById(R.id.password);
        mLogin=findViewById(R.id.login);
        mPresenterInterface =new LoginModel(this);
        mLogin.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                String userName=mUser.getText().toString();
                String password=mPass.getText().toString();
                mPresenterInterface.loginPerform(userName,password);
            }
        });
    }

    @Override
    public void loginValidation() {

        Toast.makeText(this, "Validation Error", Toast.LENGTH_SHORT).show();

    }

    @Override
    public void loginSuccess() {
        Toast.makeText(this, "Login Success", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void loginError() {
        Toast.makeText(this, "You got some Error", Toast.LENGTH_SHORT).show();
    }
}
