package com.example.hrishikesh.foodreview;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.view.View.OnClickListener;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.AdapterView;

import org.w3c.dom.Text;

public class Explore extends AppCompatActivity {


    ListView L;

    String UserName="";

    int [] Images={R.drawable.atlantis,R.drawable.shangri,R.drawable.mariott,R.drawable.mayfair};
    String [] Names={"Atlantis","Shangri-La","Mariott","Mayfair"};
    String [] Desc={"Atlantis, The Palm is a majestic 5 star luxury hotel in Dubai, and is located on The Palm, a man-made island that has captured the world’s imagination with its magnificent scale and ingenuity."
                    ,"Shangri-La Hotel, Bengaluru, is the perfect place to take in the charm and character of India’s Garden City. Perched high above the horizon, offering a birds-eye view of Bangalore Palace.",
                     "Pamper Yourself In Luxury! Extraordinary Experiences. Hotels in 130+ Countries. Lowest Price for Members. Book Direct With Marriott. Award Winning Service. Best Rate Guarantee.",
                     "MAYFAIR Hotels & Resorts are synonymous with excellence in hospitality and being able to offer unforgettable holiday and stay experiences to guests in the most exquisite of settings."};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_explore);
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

        L=(ListView) findViewById(R.id.RestList);
        CustomAdapter customadapter =new CustomAdapter();
        L.setAdapter(customadapter);

        Intent in = getIntent();
        Log.d("ExploreUserName",UserName);
        UserName=in.getStringExtra("UserName");

    }

    class CustomAdapter extends BaseAdapter{


        public int getCount() {
            return Images.length;
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

            Log.d("ImageLOG",String.valueOf(Images[i]));

            View view=getLayoutInflater().inflate(R.layout.listview_layout,null);

            ImageView imageView=(ImageView)view.findViewById(R.id.ListImage);
            TextView textView=(TextView)view.findViewById(R.id.ListName);
            TextView textView1=(TextView)view.findViewById(R.id.Desc);
            Button reviewbutton=(Button)view.findViewById(R.id.review);

            imageView.setImageResource(Images[i]);
            textView.setText(Names[i]);
            textView1.setText(Desc[i]);

            final int ik=i;

            reviewbutton.setOnClickListener(new OnClickListener()
            {

                public void onClick(View v)
                {

                    Intent intent=new Intent(v.getContext(),RestReview.class);
                    intent.putExtra("Name",Names[ik]);
                    intent.putExtra("ImgID",Images[ik]);
                    intent.putExtra("Desc",Desc[ik]);
                    intent.putExtra("UserName",UserName);
                    startActivity(intent);

                }

            });

            return view;
        }
    }

}
