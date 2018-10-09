package com.example.daffolap_172.roomdemo.SQLite;

import android.content.ContentValues;
import android.content.Context;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import com.example.daffolap_172.roomdemo.presenter.PresenterClass;

public class SQLiteDB extends SQLiteOpenHelper implements SQLDBInterface {

    public static final String DATABASE_NAME="User.db";

    public static final String TABLE_NAME="Student";

    public static final String Col_1="ID";

    public static final String Col_2="NAME";

    public static final String Col_3="EMAIL";

    public SQLiteDB(Context context) {

        super(context, DATABASE_NAME,null , 1);

    }

    @Override
    public void save(int id, String name, String email) {

        SQLiteDatabase db=this.getWritableDatabase();

        ContentValues contentValues=new ContentValues();

        contentValues.put(Col_1,id);

        contentValues.put(Col_2,name);

        contentValues.put(Col_3,email);

        db.insert(TABLE_NAME,null,contentValues);

        Log.i("save","data is inserted successfuly");
    }

    @Override
    public void load() {

        SQLiteDatabase db=this.getWritableDatabase();

       Cursor cursor= db.rawQuery("select * from "+TABLE_NAME,null);

       while (cursor.moveToNext())
       {
           Log.i("load",cursor.getString(0));
           Log.i("load",cursor.getString(1));
           Log.i("load",cursor.getString(2));
       }
       // Log.i("load\n",cursor.getString(1));
        //Log.i("load\n",cursor.getString(2));
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {

        sqLiteDatabase.execSQL("create table " +TABLE_NAME+" ( ID INTEGER PRIMARY KEY,NAME TEXT,EMAIL TEXT) ");

        Log.i("Create","table is created");

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS "+TABLE_NAME);

        onCreate(sqLiteDatabase);

    }
}
