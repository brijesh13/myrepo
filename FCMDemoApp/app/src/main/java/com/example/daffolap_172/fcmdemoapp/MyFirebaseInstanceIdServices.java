package com.example.daffolap_172.fcmdemoapp;

import android.content.Intent;
import android.util.Log;

import com.google.firebase.iid.FirebaseInstanceId;
import com.google.firebase.iid.FirebaseInstanceIdService;

public class MyFirebaseInstanceIdServices extends FirebaseInstanceIdService {

    public static final String TOKEN_BRODCAST="fcmtokenbrodcast";
    @Override
    public void onTokenRefresh() {
        // Get updated InstanceID token.
        String refreshedToken = FirebaseInstanceId.getInstance().getToken();
        Log.d("FCM", "Refreshed token: " + refreshedToken);

        getApplicationContext().sendBroadcast(new Intent(TOKEN_BRODCAST));
        storeToken(refreshedToken);

    }
    public void storeToken(String token){
       SharedPreferenceClass.getInstance(getApplicationContext()).stroeToken(token);
    }
}
