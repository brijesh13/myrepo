package com.example.daffolap_172.roomdemo.sharedPreferences;

import android.content.SharedPreferences;
import android.util.Log;

public class SharedPreferencsClass implements SharedPreInterface {
    @Override
    public void save(SharedPreferences sharedPreferences,int id, String name, String email) {

        SharedPreferences.Editor editor = sharedPreferences.edit();

        editor.putInt("userId", id);

        editor.putString("name",name);

        editor.putString("email",email);

        editor.apply();

        Log.i("Save","data have been saved");
    }

    @Override
    public void load(SharedPreferences pref) {

        int id=pref.getInt("userId",0);

        String name=pref.getString("name","");

        String email=pref.getString("email","");

        Log.i("Load", id+"  "+name+"  "+email);
    }
}
