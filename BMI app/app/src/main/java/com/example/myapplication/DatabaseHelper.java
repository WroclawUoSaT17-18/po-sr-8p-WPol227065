package com.example.myapplication;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

//extend is main class for database handlin
public class DatabaseHelper extends SQLiteOpenHelper {
     public static final String DATABASE_NAME = "Products.db";
     public static final String TABLE_NAME  = "products_table";
     public static final String Col_1  = "ID";
     public static final String Col_2  = "NAZWA";
     public static final String Col_3  = "BIALKO";
     public static final String Col_4  = "WEGLOWODANY";
     public static final String Col_5  = "TLUSZCZE";
     public static final String Col_6  = "ENERGIA";

    //constuctor for calling the database
    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, 1);
        SQLiteDatabase db = this.getWritableDatabase();
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        //db.execSQL("create table " + TABLE_NAME + "(ID INTEGER PRIMARY KEY AUTOINCREMENT, NAZWA TEXT, BIALKO TEXT, weglowodany TEXT, tluszcze TEXT, energia TEXT)");
        db.execSQL("CREATE TABLE " + TABLE_NAME +" (ID INTEGER PRIMARY KEY AUTOINCREMENT,NAZWA TEXT,BIALKO TEXT,WEGLOWODANY TEXT,TLUSZCZE TEXT,ENERGIA TEXT)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }

    //public boolean insertData(String nazwa, String bialko, String weglowodany, String tluszcze, String energia){
    public boolean insertData(String nazwa, String bialko, String weglowodany, String tluszcze, String energia){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(Col_2, nazwa);
        contentValues.put(Col_3, bialko);
        contentValues.put(Col_4, weglowodany);
        contentValues.put(Col_5, tluszcze);
        contentValues.put(Col_6, energia);
        long result = db.insert(TABLE_NAME, null, contentValues);//? insert: if error, returns -1 else returns inserted row value
        if (result == -1)
            return false;
        else
            return true;
    }
}
