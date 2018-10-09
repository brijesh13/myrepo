package com.example.daffolap_172.circularmenu;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.hitomi.cmlibrary.CircleMenu;
import com.hitomi.cmlibrary.OnMenuSelectedListener;
import com.hitomi.cmlibrary.OnMenuStatusChangeListener;


public class MainActivity extends AppCompatActivity {
    String iconArray[]={"facebook","twitter","youtube","gallery","camera","googledrive"};
    private CircleMenu circleMenu;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        circleMenu=(CircleMenu) findViewById(R.id.circleMenu);
        circleMenu.setMainMenu(Color.parseColor("#CDCDCD"), R.drawable.menu_bar, R.drawable.menu_bar)
                .addSubMenu(Color.parseColor("#258CFF"), R.drawable.facebook)
                .addSubMenu(Color.parseColor("#30A400"), R.drawable.twitter)
                .addSubMenu(Color.parseColor("#FF4B32"), R.drawable.gallery)
                .addSubMenu(Color.parseColor("#8A39FF"), R.drawable.googledrive)
                .addSubMenu(Color.parseColor("#FF6A00"), R.drawable.camera)
                .setOnMenuSelectedListener(new OnMenuSelectedListener() {
                    @Override
                    public void onMenuSelected(int index) {
                        Log.i("index",index+"");
                    }

                }).setOnMenuStatusChangeListener(new OnMenuStatusChangeListener() {

            @Override
            public void onMenuOpened() {}

            @Override
            public void onMenuClosed() {}

        });
    }
}
