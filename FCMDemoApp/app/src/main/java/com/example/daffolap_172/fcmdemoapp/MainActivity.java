package com.example.daffolap_172.fcmdemoapp;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {


    private TextView textView;
    private BroadcastReceiver broadcastReceiver;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView= findViewById(R.id.text_view);

        broadcastReceiver =new BroadcastReceiver() {
            @Override
            public void onReceive(Context context, Intent intent) {

                textView.setText(SharedPreferenceClass.getInstance(MainActivity.this).getToken());
            }
        };

        if(SharedPreferenceClass.getInstance(this).getToken()!=null)
        {
            textView.setText(SharedPreferenceClass.getInstance(MainActivity.this).getToken());
            Log.d("fcmtoken",SharedPreferenceClass.getInstance(this).getToken());
        }

        registerReceiver(broadcastReceiver,new IntentFilter(MyFirebaseInstanceIdServices.TOKEN_BRODCAST));
    }
}
