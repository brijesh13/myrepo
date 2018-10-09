package com.example.daffolap_172.roomdemo.manager;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.RoomDatabase;

import com.example.daffolap_172.roomdemo.model.User;

@Database(entities = User.class,version = 1)
public abstract class MyAppDatabase extends RoomDatabase {

    public abstract MyDao myDao();
}
