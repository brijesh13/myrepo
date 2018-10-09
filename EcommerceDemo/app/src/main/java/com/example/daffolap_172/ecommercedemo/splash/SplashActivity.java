package com.example.daffolap_172.ecommercedemo.splash;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.example.daffolap_172.ecommercedemo.R;
import com.example.daffolap_172.ecommercedemo.home.HomeActivity;
import com.example.daffolap_172.ecommercedemo.login.SignInActivity;
import com.example.daffolap_172.ecommercedemo.utility.SharedPreferenceUtility;

public class SplashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        init();
        Log.i("current activity","splash activity");
    }
    public void init(){
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
               //if user is registered show home screen
               //else show login screen
                Log.i("current activity","inside run method");
                if(SharedPreferenceUtility.getInstance().getString("user register").equalsIgnoreCase(""))
                {
                    Intent intent=new Intent(getApplicationContext(), SignInActivity.class);
                    startActivity(intent);
                }else{
                    Intent intent=new Intent(getApplicationContext(), HomeActivity.class);
                    startActivity(intent);
                }
                finish();
            }
        },3000);
    }
}
