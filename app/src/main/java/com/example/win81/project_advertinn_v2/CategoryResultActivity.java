package com.example.win81.project_advertinn_v2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.example.win81.project_advertinn_v2.dto.CategoryName;

import java.util.ArrayList;

public class CategoryResultActivity extends AppCompatActivity {
    ListView gv;
    ArrayList<CategoryName> cList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_category_result);
        gv=(ListView) findViewById(R.id.list_item);
        cList=new ArrayList<>();
        cList.add(new CategoryName(R.drawable.food_1,"South Indian"));
        cList.add(new CategoryName(R.drawable.food_2,"Mexian"));
        cList.add(new CategoryName(R.drawable.food_3,"Chicken"));
        cList.add(new CategoryName(R.drawable.food_4,"Burger"));
        cList.add(new CategoryName(R.drawable.food_5,"Noodels"));
        cList.add(new CategoryName(R.drawable.food_6,"Panner"));
        cList.add(new CategoryName(R.drawable.food_7,"Veg Roll"));
        cList.add(new CategoryName(R.drawable.food_3,"Mutton"));




        MyAdapter ma = new MyAdapter();
        gv.setAdapter(ma);
    }
    class MyAdapter extends ArrayAdapter<CategoryName>
    {
        public MyAdapter()
        {
            super(CategoryResultActivity.this,android.R.layout.simple_list_item_1,cList);
        }


        @Override
        public View getView(int position, View convertView, ViewGroup parent)
        {
            LayoutInflater lif = getLayoutInflater();
            View v = lif.inflate(R.layout.showcategory,null);
            ImageView iv= (ImageView)v.findViewById(R.id.imageView);
            TextView tv = (TextView)v.findViewById(R.id.info_text);
            CategoryName cn= cList.get(position);

            iv.setImageResource(cn.getImage());
            tv.setText(cn.getName());
            return v;
        }
    }
}
