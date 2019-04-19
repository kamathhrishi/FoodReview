package com.example.hrishikesh.foodreview;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;


public class ReviewDatabase extends SQLiteOpenHelper {

    public static final String DATABASE_NAME = "REVIEWS.db";
    public static final String TABLE_NAME = "reviews";
    public static final String COL1 = "User";
    public static final String COL2 = "Restaurant";
    public static final String COL3 = "Stars";
    public static final String COL4 = "Review";


    public ReviewDatabase(Context context) {
        super(context, DATABASE_NAME, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        Log.d("SQLDEBUG","REVIEWS DATABASE CREATED");

        final String createTable =

                "CREATE TABLE " + TABLE_NAME + " (" +
                        COL1 + " TEXT," +
                        COL2 + " TEXT," +
                        COL3 + " FLOAT," +
                        COL4 + " TEXT)";


        db.execSQL(createTable);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }


    public boolean addData(String User,String Restaurant,float Stars,String Reviews) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL1,User);
        contentValues.put(COL2,Restaurant);
        contentValues.put(COL3,Stars);
        contentValues.put(COL4,Reviews);

        long result = db.insert(TABLE_NAME, null, contentValues);
        Log.d("hmm","INSERTED");
        Log.d("Values inserted",(User+" "+Restaurant+" "+String.valueOf(Stars)+" "+Reviews));

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

    public boolean ReviewExists(String Name){

        SQLiteDatabase db = this.getWritableDatabase();
        String query="SELECT * FROM " + TABLE_NAME+" WHERE "+"Restaurant=='" + Name+"'";
        Log.d("SQLDEBUG",query);
        Cursor data = db.rawQuery(query, null);

        if(data.getCount()==0){


            return false;

        }
        else {


            return true;


        }


    }
    public Cursor GetUserReviews(String Name){
        SQLiteDatabase db = this.getWritableDatabase();
        String query="SELECT * FROM " + TABLE_NAME+" WHERE "+"Restaurant=='" + Name+"'";
        Log.d("SQLDEBUG",query);
        Cursor data = db.rawQuery(query, null);

        return data;

    }

}