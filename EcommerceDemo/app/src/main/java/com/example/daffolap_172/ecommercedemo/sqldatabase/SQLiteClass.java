package com.example.daffolap_172.ecommercedemo.sqldatabase;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import com.example.daffolap_172.ecommercedemo.home.Product;

import java.sql.Blob;
import java.util.ArrayList;

public class SQLiteClass extends SQLiteOpenHelper implements SQLiteInterface{
    public static final String DATABASE_NAME="Data.db";

    public static final String TABLE_NAME="Product";

    public static final String Col_1="ID";

    public static final String Col_2="NAME";

    public static final String Col_3="BRAND";

    public static final String Col_4="PRICE";

    public static final String Col_5="IMAGE";
    public SQLiteClass(Context context) {

        super(context, DATABASE_NAME,null , 1);
        Log.i("SQL","constructor of sqlitedatabase");

    }

    @Override
    public ArrayList<Product> load() {

        SQLiteDatabase db=this.getReadableDatabase();

        Log.i("load method",db+"");

        Cursor cursor= db.rawQuery("SELECT * FROM Product",null);
        Log.i("load",cursor+"");
        while (cursor.moveToNext())
        {
            Log.i("load",cursor.getString(0));
            Log.i("load",cursor.getString(1));
            Log.i("load",cursor.getString(2));
            Log.i("load",cursor.getString(3));
        }
        return null;
    }

    @Override
    public void save(int id, String name, String brand,int price,String image) {
        SQLiteDatabase db=this.getWritableDatabase();

        ContentValues contentValues=new ContentValues();

        contentValues.put(Col_1,id);
        contentValues.put(Col_2,name);
        contentValues.put(Col_3,brand);
        contentValues.put(Col_4,price);
        contentValues.put(Col_4,image);

        db.insert(TABLE_NAME,null,contentValues);

        Log.i("save","data is inserted successfuly");
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {

        sqLiteDatabase.execSQL("create table " +TABLE_NAME+" ( ID INTEGER PRIMARY KEY,NAME TEXT,BRAND TEXT,PRICE INTEGER,IMAGE BLOB) ");
        Log.i("Create","table is created");

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS "+TABLE_NAME);

        onCreate(sqLiteDatabase);

    }
}
