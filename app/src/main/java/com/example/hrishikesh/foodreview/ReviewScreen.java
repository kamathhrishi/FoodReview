package com.example.hrishikesh.foodreview;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.RatingBar;
import android.widget.TextView;

public class ReviewScreen extends AppCompatActivity {


    String RestName;
    String UserName;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_review_screen);
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

        TextView HomeScreen=(TextView)findViewById(R.id.HomeScreen);
        Intent Recieve=getIntent();
        RestName=Recieve.getStringExtra("Name");
        UserName=Recieve.getStringExtra("UserName");

        HomeScreen.setText("Your Review of : "+RestName);

    }

    public void OnSubmit(View view){

             RatingBar Rate=(RatingBar)findViewById(R.id.Review_Rating);
             TextView  reviewtext=(TextView)findViewById(R.id.Review_Text);

             float rating=Rate.getRating();


             ReviewDatabase Database=new ReviewDatabase(this);
             Database.addData(UserName,RestName,rating,String.valueOf(reviewtext.getText()));

             Intent intent = new Intent(this,Explore.class);
             startActivity(intent);


    }

}
