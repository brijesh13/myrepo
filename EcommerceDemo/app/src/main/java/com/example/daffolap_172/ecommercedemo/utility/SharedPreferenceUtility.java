package com.example.daffolap_172.ecommercedemo.utility;

import android.content.Context;
import android.content.SharedPreferences;

import com.example.daffolap_172.ecommercedemo.MyApp;

public class SharedPreferenceUtility {

    private static String PREFERENCE_NAME="ecommerce";

    private static SharedPreferenceUtility sharedPreferenceUtility;

    private SharedPreferences sharedPreferences;

    public SharedPreferenceUtility(Context context) {

        PREFERENCE_NAME=PREFERENCE_NAME+context.getPackageName();
        this.sharedPreferences=context.getSharedPreferences(PREFERENCE_NAME,context.MODE_PRIVATE);

    }
    public static SharedPreferenceUtility getInstance(){
        if(sharedPreferenceUtility==null)
        {
            sharedPreferenceUtility=new SharedPreferenceUtility(MyApp.getContext());
        }
        return sharedPreferenceUtility;
    }
    //login user_id 1234
    public void saveString(String key ,String val)
    {
        SharedPreferences.Editor editor=sharedPreferences.edit();
        editor.putString(key,val);
        editor.commit();
    }
    public String getString(String key,String defVal){
        return sharedPreferences.getString(key, defVal);
    }
    public String getString(String key){
        return sharedPreferences.getString(key,"");
    }
}
