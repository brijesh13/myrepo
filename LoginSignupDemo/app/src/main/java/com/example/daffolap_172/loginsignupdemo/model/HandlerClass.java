package com.example.daffolap_172.loginsignupdemo.model;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class HandlerClass extends SQLiteOpenHelper implements HandlerInterface {
    public static final String DATABASE_NAME="User.db";

    public static final String TABLE_NAME="User";

    public static final String Col_1="NAME";

    public static final String Col_2="EMAIL";

    public static final String Col_3="PASSWORD";

    public HandlerClass(Context context) {

        super(context, DATABASE_NAME,null , 1);

    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL("create table " +TABLE_NAME+" (NAME TEXT,EMAIL TEXT PRIMARY KEY,PASSWORD TEXT) ");

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS "+TABLE_NAME);
        onCreate(sqLiteDatabase);
    }

    @Override
    public boolean login(String email, String password) {
        SQLiteDatabase db=this.getReadableDatabase();
        Cursor cursor= db.rawQuery("SELECT * FROM User WHERE EMAIL=? AND PASSWORD=?",new String[]{email,password});
        Log.i("login",cursor.getCount()+"");
        if(cursor.getCount()==1){
            return true;
        }
        return false;
    }

    @Override
    public boolean signup(String name, String email, String password) {
        SQLiteDatabase db=this.getWritableDatabase();

        ContentValues contentValues=new ContentValues();

        contentValues.put(Col_1,name);

        contentValues.put(Col_2,email);

        contentValues.put(Col_3,password);

        db.insert(TABLE_NAME,null,contentValues);

        Log.i("save","data is inserted successfuly");
        return true;
    }
}
