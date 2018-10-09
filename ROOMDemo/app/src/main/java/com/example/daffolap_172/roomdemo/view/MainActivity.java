package com.example.daffolap_172.roomdemo.view;

import android.arch.persistence.room.Room;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import com.example.daffolap_172.roomdemo.R;
import com.example.daffolap_172.roomdemo.manager.MyAppDatabase;
import com.example.daffolap_172.roomdemo.model.User;
import com.example.daffolap_172.roomdemo.presenter.PresenterClass;

import java.util.List;

public class MainActivity extends AppCompatActivity implements ViewInetrface {

    public static FragmentManager fragmentManager;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        fragmentManager=getSupportFragmentManager();

        if(findViewById(R.id.frame_layout)!=null)
        {
          if(savedInstanceState!=null)
          {
              return;
          }
          fragmentManager.beginTransaction().add(R.id.frame_layout,new HomeFragment()).commit();
        }
    }

    @Override
    public void onSuccess() {

        Toast.makeText(this, "User Successfuly added in to the database", Toast.LENGTH_SHORT).show();

    }

    @Override
    public void onfailure() {

    }


}
