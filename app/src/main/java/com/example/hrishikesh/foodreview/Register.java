package com.example.hrishikesh.foodreview;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.Editable;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

public class Register extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
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

    public void OnClick(View view){

        EditText Name_f=findViewById(R.id.Name_R);
        EditText Phone_f=findViewById(R.id.Number_R);
        EditText Password_f=findViewById(R.id.Pass_R);
        EditText Password_A_f=findViewById(R.id.Pass_AR);


        String Name=Name_f.getText().toString();
        String Phone=Phone_f.getText().toString();
        String Password=Password_f.getText().toString();
        String Password_A=Password_A_f.getText().toString();

        DatabaseHelper m;
        m=new DatabaseHelper(this);

        boolean b=m.addData(Name,Phone,Password);
        Log.d("INSERT_NAME",Name);
        Log.d("INSERT_PHONE",Phone);
        Log.d("INSERT_PASS",Password);
        Log.d("ADDEDDATA",String.valueOf(b));

        Intent intent=new Intent(this,Login.class);
        startActivity(intent);


    }

}
