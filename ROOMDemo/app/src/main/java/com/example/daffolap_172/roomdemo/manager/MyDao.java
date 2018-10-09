package com.example.daffolap_172.roomdemo.manager;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import com.example.daffolap_172.roomdemo.model.User;

import java.util.List;

@Dao
public interface MyDao {
    @Insert
    void addUser(User user);

    @Query("select * from users")
    public List<User> getUsers();
}
