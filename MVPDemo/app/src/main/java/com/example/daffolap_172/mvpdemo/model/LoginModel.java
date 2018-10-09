package com.example.daffolap_172.mvpdemo.model;

import android.text.TextUtils;

import com.example.daffolap_172.mvpdemo.presenter.PresenterInterface;
import com.example.daffolap_172.mvpdemo.view.ViewIneterface;

public class LoginModel implements PresenterInterface {
    ViewIneterface mLoginView;
    public LoginModel(ViewIneterface loginView) {

        mLoginView=loginView;
    }

    @Override
    public void loginPerform(String user, String pass) {

        if(TextUtils.isEmpty(user)||TextUtils.isEmpty(pass))
        {
            mLoginView.loginValidation();
        }
        else if(user.equals("admin")&& pass.equals("admin"))
        {
            mLoginView.loginSuccess();
        }
        else {
            mLoginView.loginError();
        }

    }
}
