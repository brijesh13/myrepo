package com.example.daffolap_172.roomdemo.presenter;

import android.arch.persistence.room.Room;
import android.content.Context;
import android.content.SharedPreferences;

import com.example.daffolap_172.roomdemo.SQLite.SQLiteDB;
import com.example.daffolap_172.roomdemo.manager.ManagerClass;
import com.example.daffolap_172.roomdemo.manager.MyAppDatabase;
import com.example.daffolap_172.roomdemo.model.User;
import com.example.daffolap_172.roomdemo.sharedPreferences.SharedPreferencsClass;
import com.example.daffolap_172.roomdemo.view.MainActivity;
import com.example.daffolap_172.roomdemo.view.ViewInetrface;

import java.util.List;

public class PresenterClass implements PresenterInterface {

    MainActivity mView;
    public static MyAppDatabase myAppDatabase;
    int userId;
    String name,email;
    public PresenterClass(MainActivity mView, int userId, String name, String email)
    {
        this.mView=mView;
        this.userId=userId;
        this.name=name;
        this.email=email;
    }
    public PresenterClass(MainActivity mView)
    {
        this.mView=mView;
    }
    @Override
    public void datbaseCallbackSuccess() {

        mView.onSuccess();

    }

    @Override
    public void datbaseCallbackFailure() {

    }

    @Override
    public void insert() {
        //Room Database

//        myAppDatabase= Room.databaseBuilder(mView.getApplicationContext(),MyAppDatabase.class,"userDb").allowMainThreadQueries().build();
//        ManagerClass manager=new ManagerClass(this);
//        manager.insert(userId,name,email);

        //for SharedPreferences

//        SharedPreferences pref = mView.getSharedPreferences("MyPref", Context.MODE_PRIVATE);
//
//        SharedPreferencsClass sharePre=new SharedPreferencsClass();
//
//        sharePre.save(pref,userId,name,email);
       //SQLiteDatabase
        SQLiteDB sqLiteDB=new SQLiteDB(mView.getApplicationContext());

        sqLiteDB.save(userId,name,email);

    }

    @Override
    public void view() {
        //Room Database

            //myAppDatabase= Room.databaseBuilder(mView.getApplicationContext(),MyAppDatabase.class,"userDb").allowMainThreadQueries().build();
            //ManagerClass manager=new ManagerClass(this);
            //manager.view();
            //shareperences
//        SharedPreferences pref = mView.getSharedPreferences("MyPref", Context.MODE_PRIVATE);
//
//        SharedPreferencsClass sharePre=new SharedPreferencsClass();
//
//        sharePre.load(pref);
        //SQLiteDatabase
        SQLiteDB sqLiteDB=new SQLiteDB(mView.getApplicationContext());

        sqLiteDB.load();


    }

    @Override
    public void viewSuccess(List<User> list) {

    }
}
