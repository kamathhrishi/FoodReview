package com.example.hrishikesh.foodreview;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.EditText;


public class Login extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }

    public void  OnClick_login(View v){

        EditText Name_f=findViewById(R.id.User_Name);
        EditText Password_f=findViewById(R.id.User_Pass);

        String Name=Name_f.getText().toString();
        String Password=Password_f.getText().toString();

        DatabaseHelper m;
        m=new DatabaseHelper(this);

        if(m.CheckUserPass(Name,Password)) {

            Intent intent = new Intent(this, Home.class);
            intent.putExtra("UserName",Name);
            startActivity(intent);

        }
        else {

            Log.d("LOGIN","USER NOT FOUND");


        }



    }

}
