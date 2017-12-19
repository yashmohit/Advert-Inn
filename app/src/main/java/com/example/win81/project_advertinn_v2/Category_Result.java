package com.example.win81.project_advertinn_v2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.win81.project_advertinn_v2.dto.CategoryName;

import java.util.ArrayList;
import java.util.List;

public class Category_Result extends AppCompatActivity {

    private List<CategoryName> categoryList = new ArrayList<>();
    private RecyclerView recyclerView;
    private CategoryResult_Adapter mAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_category__result);

        recyclerView = (RecyclerView) findViewById(R.id.recycler_view);

        mAdapter = new CategoryResult_Adapter(categoryList);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(mAdapter);

        prepareMovieData();
    }

    private void prepareMovieData() {
        CategoryName cn_1 = new CategoryName(R.drawable.food_1,"Lajij ");
        categoryList.add(cn_1);

        CategoryName cn_2 = new CategoryName(R.drawable.food_2,"Lajij ");
        categoryList.add(cn_2);

        CategoryName cn_3 = new CategoryName(R.drawable.food_3,"Lajij ");
        categoryList.add(cn_3);

        CategoryName cn_4 = new CategoryName(R.drawable.food_4,"Lajij ");
        categoryList.add(cn_4);

        CategoryName cn_5 = new CategoryName(R.drawable.food_5,"Lajij ");
        categoryList.add(cn_5);

        CategoryName cn_6 = new CategoryName(R.drawable.food_6,"Lajij ");
        categoryList.add(cn_6);

        CategoryName cn_7 = new CategoryName(R.drawable.food_7,"Lajij ");
        categoryList.add(cn_7);



        mAdapter.notifyDataSetChanged();
    }
}
