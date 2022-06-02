package com.example.wj_contractor;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DBConnector extends SQLiteOpenHelper {


    public DBConnector(Context con){

        super(con , "WJ_Contractor" , null,1);


    }
    @Override
    public void onCreate(SQLiteDatabase db) {

        db.execSQL("CREATE TABLE admin (name text, age int, number int, nic text, username text, password text, email text)");
        db.execSQL("CREATE TABLE supervisor(name text, age int, number int, nic text, username text, password text, email text)");
        db.execSQL("CREATE TABLE newSite(SiteName text, SupervisorName text, Location text, StartDate text, EndDate text, SiteID text)");
        db.execSQL("CREATE TABLE masonryWorkers(name text, age int, number int, nic text, email text, address text, userid text)");
        db.execSQL("CREATE TABLE attendance (workername text, id text,date text )");



    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL("drop Table if exists masonryWorkers");
        db.execSQL("drop Table if exists supervisor");

    }

    public Cursor getmasondata() {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery("SELECT * from masonryWorkers", null);
        return cursor;
    }


    public Cursor getsupervisordata() {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery("SELECT * from supervisor", null);
        return cursor;
    }
}
