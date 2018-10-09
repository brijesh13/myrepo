package com.example.daffolap_172.fcmdemoapp;

import android.content.Intent;
import android.util.Log;

import com.google.firebase.messaging.FirebaseMessagingService;
import com.google.firebase.messaging.RemoteMessage;

public class MyMessagesServices extends FirebaseMessagingService{
    private static final String TAG="fcmmessagedemo";

    @Override
    public void onMessageReceived(RemoteMessage remoteMessage) {

        // TODO(developer): Handle FCM messages here.
        // Not getting messages here? See why this may be: https://goo.gl/39bRNJ
        Log.d(TAG, "From: " + remoteMessage.getFrom());
        Log.d(TAG, "Message Notification Body: " + remoteMessage.getNotification().getBody());
        notifyUser(remoteMessage.getFrom(),remoteMessage.getNotification().getBody());
    }
    public void notifyUser(String form,String notification){
        MyNotificationManager myNotificationManger=new MyNotificationManager(getApplicationContext());

        myNotificationManger.showNotification(form,notification,new Intent(getApplicationContext(),MainActivity.class));
    }
}
