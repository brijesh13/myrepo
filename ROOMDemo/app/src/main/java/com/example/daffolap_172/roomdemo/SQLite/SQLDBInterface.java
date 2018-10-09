package com.example.daffolap_172.roomdemo.SQLite;

import android.content.SharedPreferences;

public interface SQLDBInterface {
    void save( int id, String name, String email);
    void load();
}
