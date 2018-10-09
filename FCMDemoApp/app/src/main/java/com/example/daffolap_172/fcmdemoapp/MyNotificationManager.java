package com.example.daffolap_172.fcmdemoapp;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.graphics.BitmapFactory;
import android.support.v4.app.NotificationCompat;

public class MyNotificationManager {
    private Context mContext;
    private static final int NOTIFICATION_ID=234;
    MyNotificationManager(Context context){
        mContext=context;
    }
    public void showNotification(String from, String notification, Intent intent){
        PendingIntent pendingIntent=PendingIntent.getActivity(
                mContext,
                NOTIFICATION_ID,
                intent,
                PendingIntent.FLAG_UPDATE_CURRENT
        );
        NotificationCompat.Builder builder=new NotificationCompat.Builder(mContext);

        Notification mNotification=builder.setSmallIcon(R.mipmap.ic_launcher)
                .setAutoCancel(true)
                .setContentIntent(pendingIntent)
                .setContentTitle(from)
                .setContentText(notification)
                .setLargeIcon(BitmapFactory.decodeResource(mContext.getResources(),R.mipmap.ic_launcher))
                .build();
        mNotification.flags |=Notification.FLAG_AUTO_CANCEL;

        NotificationManager notificationManager=(NotificationManager)mContext.getSystemService(Context.NOTIFICATION_SERVICE);
        if (notificationManager != null) {
            notificationManager.notify(NOTIFICATION_ID,mNotification);
        }
    }
}
