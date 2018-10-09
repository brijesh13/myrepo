package com.example.daffolap_172.loginsignupdemo.presenter;

import android.content.Context;
import android.widget.EditText;

import com.example.daffolap_172.loginsignupdemo.model.HandlerClass;

public class PresenterClass implements PreseneterInterface {
    private String email,password,name;
    private HandlerClass mHandler;
    private Context mContext;
    public PresenterClass(Context context,String email, String password) {
        mContext=context;
        this.email=email;
        this.password=password;
    }

    public PresenterClass(Context context, String mUser_name, String mEmail, String password) {
        mContext=context;
        this.email=mEmail;
        this.name=mUser_name;
        this.password=password;
    }

    @Override
    public boolean login() {
        mHandler=new HandlerClass(mContext.getApplicationContext());
        return mHandler.login(email,password);
    }

    @Override
    public boolean signup() {
        mHandler=new HandlerClass(mContext.getApplicationContext());
        return mHandler.signup(name,email,password);
    }
}
