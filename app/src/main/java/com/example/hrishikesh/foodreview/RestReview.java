package com.example.hrishikesh.foodreview;

import android.content.Intent;
import android.database.Cursor;
import android.media.Rating;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.RatingBar;
import android.widget.TextView;

import java.util.ArrayList;

public class RestReview extends AppCompatActivity {

    String RestName="";
    String UserName="";
    ListView L;
    ReviewDatabase Database;
    Cursor Pointer;

    ArrayList<String> User = new ArrayList<>();
    ArrayList<String> Restaurant=new ArrayList<>();
    ArrayList<Float>  Ratings=new ArrayList<>();


    boolean ReviewExists;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rest_review);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        Log.d("USERNAME",UserName);
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        ImageView imageView=(ImageView)findViewById(R.id.Review_Image);
        TextView textView=(TextView)findViewById(R.id.Review_Name);
        TextView textView1=(TextView)findViewById(R.id.Review_Desc);

        Intent intent=getIntent();
        String name=intent.getStringExtra("Name");
        RestName=name;
        UserName=intent.getStringExtra("UserName");
        //Log.d("IMAGEID",intent.getStringExtra("ImgID"));
        //long imgid=Long.valueOf(intent.getStringExtra("ImgID"));
        String des=intent.getStringExtra("Desc");

        Database=new ReviewDatabase(this);

        Log.d("RESTAURANT",RestName);
        Cursor data=Database.GetUserReviews(RestName);

        int Index=0;

        while (data.moveToNext()){

             User.add(data.getString(0));
             Restaurant.add(data.getString(3));
             Ratings.add(data.getFloat(2));

             Log.d("SQL Retrieve",User.get(Index));
             Log.d("SQL Retrieve",Restaurant.get(Index));

             Index+=1;

        }

        L=(ListView) findViewById(R.id.Review_List);
        CustomAdapter customadapter =new CustomAdapter();
        L.setAdapter(customadapter);



        //imageView.setImageResource(imgid);
        textView.setText(name);
        textView1.setText(des);

        ReviewExists=Database.ReviewExists(RestName);
        Pointer=Database.GetUserReviews(RestName);



    }

    public void OnClick(View view){


        Intent intent =new Intent(this,ReviewScreen.class);
        intent.putExtra("Name",RestName);
        intent.putExtra("UserName",UserName);
        startActivity(intent);

    }

    class CustomAdapter extends BaseAdapter{


        public int getCount() {
            return User.size();
        }

        public Object getItem(int i) {
            return null;
        }

        public long getItemId(int i) {
            return 0;
        }

        protected void onListItemClick(ListView l, View v, int position, long id) {

            Log.i("Hello!", "Clicked! YAY!");

        }


        public View getView(int i, View convertView, ViewGroup viewGroup) {


            View view=getLayoutInflater().inflate(R.layout.reviewlayout,null);

            TextView textView=(TextView)view.findViewById(R.id.ReviewAuthor);
            TextView textView1=(TextView)view.findViewById(R.id.Review_Content);
            RatingBar rate=(RatingBar)view.findViewById(R.id.inreview_rating);

            textView.setText(User.get(i));
            textView1.setText(String.valueOf(Restaurant.get(i)));
            rate.setRating(Ratings.get(i));


            return view;
        }
    }

}
