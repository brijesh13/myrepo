package com.example.daffolap_172.profile.model;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class DatabaseHelper extends SQLiteOpenHelper implements DatabaseHelperInterface{
    private static final String DATABASE_NAME="User.db";
    private static final String TABLE_NAME="ImageData";
    private static final String Col_2="IMAGE";
    private static final String Col_1="ID";
    private String iconArray[]={"facebook","twitter","youtube","gallery","google_drive","camera"};
    public DatabaseHelper(Context context) {

        super(context, DATABASE_NAME,null , 1);
        Log.i("SQL","constructor of sqlitedatabase");

    }

    @Override
    public void load() {

        SQLiteDatabase db=this.getReadableDatabase();

        Log.i("load method",db+"");

        Cursor cursor= db.rawQuery("SELECT * FROM ImageData",null);
        Log.i("load",cursor+"");
        while (cursor.moveToNext())
        {
            Log.i("load",cursor.getCount()+"");
        }
    }

    @Override
    public boolean save(byte[] image) {
        SQLiteDatabase db=this.getWritableDatabase();
        Log.i("save",db+"");
        ContentValues contentValues=new ContentValues();
        contentValues.put(Col_1,4);
        contentValues.put(Col_2,image);

        db.insert(TABLE_NAME,null,contentValues);

        Log.i("save","data is inserted successfuly");
        return true;
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {

        sqLiteDatabase.execSQL("create table " +TABLE_NAME+" ( ID INTEGER  PRIMARY KEY AUTOINCREMENT,IMAGE BLOB) ");
        Log.i("Create","table is created");

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS "+TABLE_NAME);

        onCreate(sqLiteDatabase);

    }
}
