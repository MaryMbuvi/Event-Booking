package com.example.marymbuvi.eventbookingapp; /**
 * Created by Mary Mbuvi on 5/8/2018.
 */


import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Mary Mbuvi on 5/8/2018.
 */

public class DatabaseHelperEvent extends SQLiteOpenHelper{

    public static final String DATABASE_NAME = "Clients.db";
    public static final String TABLE_NAME = "clients_table";
    public static final String COL_1 = "ID";
    public static final String COL_2 = "fullname";
    public static final String COL_3 = "phone";
    public static final String COL_4 = "event";
    public static final String COL_5 = "position";
    public static final String COL_6 = "amount";
    public static final String COL_7 = "date";

    public DatabaseHelperEvent(Context context) {
        super(context, DATABASE_NAME, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table " + TABLE_NAME +" (ID INTEGER PRIMARY KEY AUTOINCREMENT,FNAME TEXT,PHONE INTEGER, EVENT TEXT, POSITION INTEGE, AMOUNT INTEGER, DATE DATE)");
    }

    public Cursor getAllData(){
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor result =  db.rawQuery("select * from "+TABLE_NAME,null);
        return result;
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }


    public boolean insertEventData(String fname, String phone, String event, String position, String amount, String date) {
        SQLiteDatabase database = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL_2, fname);
        contentValues.put(COL_3, phone);
        contentValues.put(COL_4, event);
        contentValues.put(COL_5, position);
        contentValues.put(COL_6, amount);
        contentValues.put(COL_7, date);
        long result = database.insert(TABLE_NAME, null, contentValues);
        if (result == -1)
            return false;
        else
            return true;

    }
}
