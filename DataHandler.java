package com.example.wj_contractor;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.util.ArrayList;

public class DataHandler {

    private Context con;
    private DBConnector dbCon;
    private SQLiteDatabase db;

    public DataHandler(Context con){
        this.con = con;
    }

    public DataHandler openDB(){
        this.dbCon = new DBConnector(con);
        this.db = dbCon.getWritableDatabase();
        return this;
    }

    public void createAdmin(Admin admin) {

        ContentValues contentValues = new ContentValues();

        contentValues.put("name", admin.getName());
        contentValues.put("age", admin.getAge());
        contentValues.put("number", admin.getNumber());
        contentValues.put("nic" , admin.getNic());
        contentValues.put("username" , admin.getUsername());
        contentValues.put("password" , admin.getPassword());
        contentValues.put("email", admin.getEmail());

        db.insert("admin", null, contentValues);

    }

    public void createSupervisors(Supervisors supervisors)  {


        ContentValues contentValues = new ContentValues();

        contentValues.put("name", supervisors.getName());
        contentValues.put("age", supervisors.getAge());
        contentValues.put("number", supervisors.getNumber());
        contentValues.put("nic", supervisors.getNic());
        contentValues.put("username", supervisors.getUsername());
        contentValues.put("password", supervisors.getPassword());
        contentValues.put("email", supervisors.getEmail());

        db.insert("supervisor", null, contentValues);
    }


    public void addNewSite(AddNewSite addNewSite){

        ContentValues contentValues = new ContentValues();

        contentValues.put("SiteName", addNewSite.getSiteName());
        contentValues.put("SupervisorName", addNewSite.getSupervisorName());
        contentValues.put("Location", addNewSite.getLocation());
        contentValues.put("StartDate", addNewSite.getStartDate());
        contentValues.put("EndDate", addNewSite.getEndDate());
        contentValues.put("SiteID", addNewSite.getSiteID());

        db.insert("newSite", null, contentValues);
    }

    public void addMasonryWorkers(MasonryWorkers masonryWorkers){

        ContentValues contentValues = new ContentValues();

        contentValues.put("name", masonryWorkers.getName());
        contentValues.put("age", masonryWorkers.getAge());
        contentValues.put("number", masonryWorkers.getNumber());
        contentValues.put("nic" , masonryWorkers.getNic());
        contentValues.put("email" , masonryWorkers.getEmail());
        contentValues.put("address" , masonryWorkers.getAddress());
        contentValues.put("userid", masonryWorkers.getUserid());

        db.insert("masonryWorkers", null, contentValues);

    }

    public void updateSupervisor(Supervisors supervisors){

        ContentValues contentValues = new ContentValues();

        contentValues.put("name", supervisors.getName());
        contentValues.put("age", supervisors.getAge());
        contentValues.put("number", supervisors.getNumber());
        contentValues.put("nic", supervisors.getNic());
        contentValues.put("username", supervisors.getUsername());
        contentValues.put("password", supervisors.getPassword());
        contentValues.put("email", supervisors.getEmail());

        db.update("supervisor",contentValues,"username=?", new String[]{supervisors.getUsername()});

    }

    public void updateMasonryWorkers(MasonryWorkers masonryWorkers){

        ContentValues contentValues = new ContentValues();

        contentValues.put("name", masonryWorkers.getName());
        contentValues.put("age", masonryWorkers.getAge());
        contentValues.put("number", masonryWorkers.getNumber());
        contentValues.put("nic", masonryWorkers.getNic());
        contentValues.put("email", masonryWorkers.getEmail());
        contentValues.put("address", masonryWorkers.getAddress());
        contentValues.put("userid", masonryWorkers.getUserid());

        db.update("masonryWorkers",contentValues,"userid=?", new String[]{masonryWorkers.getUserid()});
    }

    public void markAttendance(MarkAttendance markAttendance){

        ContentValues contentValues = new ContentValues();

        contentValues.put("workername", markAttendance.getWorkername());
        contentValues.put("id", markAttendance.getId());
        contentValues.put("date", markAttendance.getDate());


        db.insert("attendance", null, contentValues);
    }

    public Integer deleteSupervisor(String username){
        this.db = dbCon.getWritableDatabase();
        return db.delete("supervisor", "username=?",new String[]{username});
    }


    public  Integer deleteMason(String userid){
        this.db = dbCon.getWritableDatabase();
        return db.delete("masonryWorkers","userid=?", new String[]{userid} );
    }

    public ArrayList<Admin> getAllUsers(){
        return null;
    }


    public boolean checkAdminLogin(String username, String password) {
        Cursor cursor = db.rawQuery("SELECT * FROM  admin WHERE username=? and password=?", new String[]{username, password});
        if (cursor.getCount() > 0) {
            return true;
        } else {
            return false;
        }
    }


    public boolean checkSupervisorsLogin(String username, String password) {
        Cursor cursor = db.rawQuery("SELECT * FROM  supervisor WHERE username=? and password=?", new String[]{username, password});
        if (cursor.getCount() > 0) {
            return true;
        } else {
            return false;
        }
    }

}
