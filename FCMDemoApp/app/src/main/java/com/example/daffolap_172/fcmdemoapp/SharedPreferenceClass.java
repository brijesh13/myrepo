package com.example.daffolap_172.fcmdemoapp;

import android.content.Context;
import android.content.SharedPreferences;

public class SharedPreferenceClass {

    private static final String SHARED_PREF_NAME="fcmsharedpref";
    private static  final String KEY_ACCESS_TOKEN="token";

    private static Context mContext;
    private static SharedPreferenceClass mInstance;

    private SharedPreferenceClass(Context context)
    {
        mContext=context;
    }

    public static synchronized SharedPreferenceClass getInstance(Context context)
    {
        if(mInstance==null)
        {
            mInstance=new SharedPreferenceClass(context);
        }
        return mInstance;
    }
    public boolean stroeToken(String token)
    {
        SharedPreferences sharedPreferences=mContext.getSharedPreferences(SHARED_PREF_NAME,Context.MODE_PRIVATE);
        SharedPreferences.Editor editor=sharedPreferences.edit();
        editor.putString(KEY_ACCESS_TOKEN,token);
        editor.apply();
        return true;
    }
    public String getToken(){
        SharedPreferences sharedPreferences=mContext.getSharedPreferences(SHARED_PREF_NAME,Context.MODE_PRIVATE);
        return sharedPreferences.getString(KEY_ACCESS_TOKEN,null);
    }
}
