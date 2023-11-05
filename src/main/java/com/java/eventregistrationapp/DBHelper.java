package com.java.eventregistrationapp;

import static android.content.ContentValues.*;

import android.content.ContentValues;
import 	android.content.ContentResolver;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DBHelper extends SQLiteOpenHelper {
    public static final String DBNAME="Registration.db";
    public DBHelper(Context context) {
        super(context, "Registration.db", null , 1);
    }

    @Override
    public void onCreate(SQLiteDatabase MyDB) {
        MyDB.execSQL("create Table users(username TEXT primary key, email TEXT, number TEXT, college TEXT)");

    }

    @Override
    public void onUpgrade(SQLiteDatabase MyDB, int oldVersion, int newVersion) {
        MyDB.execSQL("drop Table if exists users");

    }

    public Boolean insertData(String username, String email, String number, String college) {
        SQLiteDatabase MyDB = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("username", username);
        contentValues.put("email", email);
        contentValues.put("number", number);
        contentValues.put("college", college);
        long result = MyDB.insert("users", null, contentValues);
        if (result == -1) return false;
        else return true;
    }
    public Boolean checkusername(String username){
        SQLiteDatabase MyDB = this.getWritableDatabase();
        Cursor cursor = MyDB.rawQuery("Select * from users where username = ?", new String[]{username});
        if (cursor.getCount()>0)
            return true;
        else
            return false;
    }
    public Boolean checkemail(String username,String email){
        SQLiteDatabase MyDB = this.getWritableDatabase();
        Cursor cursor = MyDB.rawQuery("Select * from users where username = ?", new String[]{username, email});
        if (cursor.getCount()>0)
            return true;
        else
            return false;
    }
    public Boolean checknumber(String username, String number){
        SQLiteDatabase MyDB = this.getWritableDatabase();
        Cursor cursor = MyDB.rawQuery("Select * from users where username = ?", new String[]{username, number});
        if (cursor.getCount()>0)
            return true;
        else
            return false;
    }
    public Boolean checkcollege(String username, String college){
        SQLiteDatabase MyDB = this.getWritableDatabase();
        Cursor cursor = MyDB.rawQuery("Select * from users where username = ?", new String[]{username, college});
        if (cursor.getCount()>0)
            return true;
        else
            return false;
    }


}
