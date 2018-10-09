package com.example.daffolap_172.servicesdemo;
import android.annotation.SuppressLint;
import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v4.app.NotificationCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.RemoteViews;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public class MainActivity extends AppCompatActivity implements OnClickListener {

    //alarm Manager
    AlarmManager mAlarmManager;
    TimePicker mTimePicker;
    TextView mUpdateText;
    Context mContext;
    Button mAlarm_on,mAlarm_off;
    Intent intent;
    PendingIntent mPendingIntent;
    int minutes,hour;
    String hour_str,minutes_str;
    Calendar calendar;
    @RequiresApi(api = Build.VERSION_CODES.M)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        this.mContext=this;
        mAlarmManager=(AlarmManager) getSystemService(ALARM_SERVICE);
        mTimePicker=findViewById(R.id.time_picker);
        mTimePicker.setIs24HourView(false);
        mUpdateText=findViewById(R.id.update_text);
        mAlarm_on =findViewById(R.id.alarm_on);
        mAlarm_off =findViewById(R.id.alarm_off);
        hour=mTimePicker.getHour();
        minutes=mTimePicker.getMinute();
        calendar=Calendar.getInstance();
        intent=new Intent(this.mContext,AlarmReceiver.class);
        mTimePicker.setOnTimeChangedListener(new TimePicker.OnTimeChangedListener() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onTimeChanged(TimePicker view, int hourOfDay, int minute) {
                // display a toast with changed values of time picker
                hour_str=String.valueOf(hourOfDay);
                minutes_str=String.valueOf(minute);
                Toast.makeText(getApplicationContext(), hourOfDay + " " + minute, Toast.LENGTH_SHORT).show();
                mUpdateText.setText(" Now Time is :: " + hourOfDay + " : " + minute);
            }
        });

        mAlarm_on.setOnClickListener(new OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.M)
            @Override
            public void onClick(View view) {
                hour=mTimePicker.getHour();
                minutes=mTimePicker.getMinute();
                Date futureDate = new Date(new Date().getTime()+86400000);
                futureDate.setHours(hour);
                futureDate.setMinutes(minutes);
                calendar.setTime(futureDate);
                String myDate="2018/08/31"+" "+hour+":"+minutes+":00";
                long timeInMillis=0;
                SimpleDateFormat simpleDateFormat=new SimpleDateFormat("yyyy/MM/dd HH:mm:ss", Locale.ENGLISH);
                try {
                  Date date=simpleDateFormat.parse(myDate);
                  timeInMillis=date.getTime();

                }
                catch (Exception e)
                {
                  e.printStackTrace();
                }
                // Get the layouts to use in the custom notification
                RemoteViews notificationLayout = new RemoteViews(getPackageName(), R.layout.notification);
                setAlarm("Alram set to"+hour_str+":"+minutes_str);
                intent.putExtra("extra","alarm on");
                mPendingIntent=PendingIntent.getBroadcast(MainActivity.this,0,intent,PendingIntent.FLAG_UPDATE_CURRENT);
                mAlarmManager.set(AlarmManager.RTC_WAKEUP, timeInMillis,mPendingIntent);
                // Apply the layouts to the notification
                NotificationCompat.Builder builder = new NotificationCompat.Builder(getApplicationContext());
                builder.setSmallIcon(R.drawable.notification_icon);
               // builder.setStyle(new NotificationCompat.DecoratedCustomViewStyle());
                builder.setCustomContentView(notificationLayout);

            }
        });
        mAlarm_off.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                mAlarmManager.cancel(mPendingIntent);
                Intent intent = new Intent(MainActivity.this, RingtoneService.class);
                stopService(intent);
                intent.putExtra("extra","alarm off");
                setAlarm("Alarm Off!");

            }
        });

    }
    private void setAlarm(String text)
    {
        mUpdateText.setText(text);
    }
    @Override
    public void onClick(View view) {

    }
}
