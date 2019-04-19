package com.example.hrishikesh.foodreview;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

public class Home extends AppCompatActivity {

    String Name="";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
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

        TextView Welcome_view=findViewById(R.id.welcome_msg);

        Intent intent=getIntent();

        String username=intent.getStringExtra("UserName");
        Name=username;


        Log.d("USERNAMELOGIN",username);

        Welcome_view.setText("Welcome "+username);

    }

    public void OnClick(View view){


        Intent intent=new Intent(this,Explore.class);
        intent.putExtra("UserName",Name);
        startActivity(intent);


    }

}
