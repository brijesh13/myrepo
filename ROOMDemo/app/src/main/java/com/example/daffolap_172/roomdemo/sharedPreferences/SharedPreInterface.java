package com.example.daffolap_172.roomdemo.sharedPreferences;

import android.content.SharedPreferences;

public interface SharedPreInterface {
    void save(SharedPreferences shareP, int id, String name, String email);
    void load(SharedPreferences pref);
}
