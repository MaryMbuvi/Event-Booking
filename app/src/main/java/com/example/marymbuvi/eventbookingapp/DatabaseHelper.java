package com.example.marymbuvi.eventbookingapp;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Mary Mbuvi on 5/8/2018.
 */

public class DatabaseHelper extends SQLiteOpenHelper{

    public static final String DATABASE_NAME = "Clients.db";
    public static final String TABLE_NAME = "clients_table";
    public static final String COL_1 = "ID";
    public static final String COL_2 = "FNAME";
    public static final String COL_3 = "SNAME";
    public static final String COL_4 = "EMAIL";
    public static final String COL_5 = "PHONE";
    public static final String COL_6 = "GENDER";
    public static final String COL_7 = "PASSWORD";

    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table " + TABLE_NAME +" (ID INTEGER PRIMARY KEY AUTOINCREMENT,FNAME TEXT,SNAME TEXT,EMAIL TEXT, PHONE INTEGER, GENDER TEXT, PASSWORD TEXT)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL("DROP TABLE IF EXISTS "+TABLE_NAME);
        onCreate(db);
    }

    public boolean insertData(String fname, String sname, String email,
                              String phone, int gender, String password) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL_2, fname);
        contentValues.put(COL_3, sname);
        contentValues.put(COL_4, email);
        contentValues.put(COL_5, phone);
        contentValues.put(COL_6, gender);
        contentValues.put(COL_7, password);
        long result = db.insert(TABLE_NAME, null, contentValues);
        if (result == -1)
            return false;
        else
            return true;

    }

        public Cursor getAllData(){
            SQLiteDatabase db = this.getWritableDatabase();
            Cursor result =  db.rawQuery("select * from "+TABLE_NAME,null);
            return result;
    }
}
