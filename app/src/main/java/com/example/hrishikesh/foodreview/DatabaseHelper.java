package com.example.hrishikesh.foodreview;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;


public class DatabaseHelper extends SQLiteOpenHelper {

    public static final String DATABASE_NAME = "USERS.db";
    public static final String TABLE_NAME = "user_details";
    public static final String COL1 = "ID";
    public static final String COL2 = "Name";
    public static final String COL3 = "PHONE";
    public static final String COL4 = "PASSWORD";


    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {


        final String createTable =

                "CREATE TABLE " + TABLE_NAME + " (" +
                        COL1 + " INTEGER PRIMARY KEY," +
                        COL2 + " TEXT," +
                        COL3 + " TEXT," +
                        COL4 + " TEXT)";


        db.execSQL(createTable);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }


    public boolean addData(String name,String phone,String Password) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL2,name);
        contentValues.put(COL3,phone);
        contentValues.put(COL4,Password);

        long result = db.insert(TABLE_NAME, null, contentValues);
        Log.d("hmm","INSERTED");

        //if date as inserted incorrectly it will return -1
        if (result == -1) {
            return false;
        } else {
            return true;
        }
    }
    public Cursor getListContents(){
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor data = db.rawQuery("SELECT * FROM " + TABLE_NAME, null);
        return data;
    }

    public boolean CheckUserPass(String Name,String Pass){
        SQLiteDatabase db = this.getWritableDatabase();
        String query="SELECT * FROM " + TABLE_NAME+" WHERE "+" Name=='" + Name+"'" + " AND "+" PASSWORD='"+Pass+"'";
        Log.d("SQLDEBUG",query);
        Cursor data = db.rawQuery(query, null);
        int count=data.getCount();



        data.moveToFirst();

        int i=0;

        while(i!=data.getCount()){

              Log.d("SQL COUNT",String.valueOf(data.getCount()));
              Log.d("SQL PRINT1",String.valueOf(data.getString(1)));
              Log.d("SQL PRINT2",String.valueOf(data.getString(2)));
              Log.d("SQL PRINT3",String.valueOf(data.getString(3)));
              data.moveToNext();
              i+=1;


        }


        if(count==0){

            return false;

        }
        else{

            return true;

        }

    }

}
