package com.example.hrishikesh.foodreview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.content.Intent;
import android.util.Log;
import android.view.*;
import android.database.Cursor;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    DatabaseHelper m;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        m=new DatabaseHelper(this);

        Cursor cursor=m.getListContents();

        if(cursor.getCount()==0){


            Log.d("LOLOL","NOTHIBT");


        }
        else {


            Cursor data=m.getListContents();
            ArrayList<String> lol=new ArrayList<String>();
            data.moveToFirst();

            while(data.moveToNext()){

                lol.add(data.getString(0));
                lol.add(data.getString(1));


            }

            for(int i=0;i<lol.size();i++){


                Log.d("DATABASE CONTENTS:",lol.get(i));


            }

        }


    }

    public void AddData(){





    }

    public void LoginButton(View view){


        Intent intent =new Intent(this,Login.class);

        startActivity(intent);

    }

    public void RegisterButton(View view){


        Intent intent =new Intent(this,Register.class);

        startActivity(intent);

    }

}
