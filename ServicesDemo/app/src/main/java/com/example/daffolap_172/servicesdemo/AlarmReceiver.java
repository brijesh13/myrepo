package com.example.daffolap_172.servicesdemo;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

public class AlarmReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {

        if (intent.getExtras().get("extra").equals("extra"))

        Log.i("hello","we are in receiver");

        String your_str=intent.getExtras().getString("extra");

        Log.i("your key",your_str);

        Intent intent_service=new Intent(context, RingtoneService.class);

        intent_service.putExtra("extra",your_str);

        context.startService(intent_service);

    }
}
