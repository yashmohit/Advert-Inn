package com.example.win81.project_advertinn_v2;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.win81.project_advertinn_v2.dto.CategoryName;

import java.util.ArrayList;

public class CategoryActivity extends AppCompatActivity {
    GridView gv;
    ArrayList<CategoryName> cList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_category);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);

        setSupportActionBar(toolbar);
   /*
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
*/
        //gridview
        gv=(GridView) findViewById(R.id.gridviewcategory_1);
        cList=new ArrayList<>();
        cList.add(new CategoryName(R.drawable.carrental,"Car Rental"));
        cList.add(new CategoryName(R.drawable.doctor,"Doctor"));
        cList.add(new CategoryName(R.drawable.fitness,"Fitness"));
        cList.add(new CategoryName(R.drawable.food,"Food"));
        cList.add(new CategoryName(R.drawable.homeservices,"Services"));
        cList.add(new CategoryName(R.drawable.hotel,"Hotel"));
        cList.add(new CategoryName(R.drawable.medicine,"Medicine"));
        cList.add(new CategoryName(R.drawable.sport,"Sport"));
        cList.add(new CategoryName(R.drawable.travel,"Travel"));



        MyAdapter ma = new MyAdapter();
        gv.setAdapter(ma);

       gv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
           @Override
           public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
               Intent in= new Intent(getApplicationContext(),CategoryResultActivity.class);
               startActivity(in);
           }
       });

    }
    class MyAdapter extends ArrayAdapter<CategoryName>
    {
        public MyAdapter()
        {
            super(CategoryActivity.this,android.R.layout.simple_gallery_item,cList);
        }


        @Override
        public View getView(int position, View convertView,  ViewGroup parent)
        {
            LayoutInflater lif = getLayoutInflater();
            View v = lif.inflate(R.layout.showcategorylist,null);
            ImageView iv= (ImageView)v.findViewById(R.id.imageViewCategory);
            TextView tv = (TextView)v.findViewById(R.id.tvCategogory_2);
            CategoryName cn= cList.get(position);

            iv.setImageResource(cn.getImage());
            tv.setText(cn.getName());
            return v;
        }
    }


}
