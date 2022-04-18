package com.example.dell.blood_bank_mgmt;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;


public class DatabaseHelper2 extends SQLiteOpenHelper {

    public static final String DATABASE_NAME = "database.db";
    public static final String TABLE_NAME = "donor_table";
    public static final String COL_1 = "ID";
    public static final String COL_2 = "NAME";
    public static final String COL_3 = "BLOODGROUP";
    public static final String COL_4 = "AGE";
    public static final String COL_5 = "CONTACTNO";
    public static final String COL_6 = "LOCATION";

    public DatabaseHelper2(Context context) {
        super(context, DATABASE_NAME, null, 1);
        SQLiteDatabase db = this.getWritableDatabase();
    }


    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("Create Table " + TABLE_NAME + " (ID INTEGER PRIMARY KEY AUTOINCREMENT,NAME TEXT,BLOODGROUP TEXT,AGE INTEGER, CONTACTNO INTEGER, LOCATION TEXT )");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS "+TABLE_NAME);

    }

    public boolean insertData(String name,String bloodgroup,String age,String contactno, String location)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL_2,name);
        contentValues.put(COL_3,bloodgroup);
        contentValues.put(COL_4,age);
        contentValues.put(COL_5, contactno);
        contentValues.put(COL_6, location);

        long result = db.insert(TABLE_NAME, null, contentValues);

        if(result ==-1)
            return false;
        else
            return true;

    }
    public Cursor getAllData()
    {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor res = db.rawQuery("select * from "+TABLE_NAME,null);
        return res;

    }


}
