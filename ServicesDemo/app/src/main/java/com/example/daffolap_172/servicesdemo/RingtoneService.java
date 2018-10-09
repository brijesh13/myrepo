package com.example.daffolap_172.servicesdemo;

import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.util.Log;

public class RingtoneService extends Service {
    MediaPlayer mMediaPlayer;

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    public int onStartCommand(Intent intent, int flags, int startId) {
        // The service is starting, due to a call to startService()
        Log.i("service","servicecommand"+startId+":"+intent);
        mMediaPlayer=MediaPlayer.create(this, R.raw.ring);
        mMediaPlayer.start();

        return START_NOT_STICKY;
    }

    @Override
    public void onDestroy() {
        mMediaPlayer.stop();
    }
}
