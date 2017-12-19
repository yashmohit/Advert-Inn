package com.example.win81.project_advertinn_v2.Adapters;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.win81.project_advertinn_v2.R;
import com.example.win81.project_advertinn_v2.dto.CategoryName;

import java.util.List;

/**
 * Created by Win 8.1 on 19/12/2017.
 */


public class CategoryAdapter extends RecyclerView.Adapter<CategoryAdapter.MyViewHolder> {

    private List<CategoryName> categoryList;

    public CategoryAdapter(List<CategoryName> categoryList) {
        this.categoryList = categoryList;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.show_category_2, parent, false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        CategoryName categoryName = categoryList.get(position);
        holder.tv.setText(categoryName.getName());
        holder.iv.setImageResource(categoryName.getImage());
    }

    @Override
    public int getItemCount() {
        return categoryList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView tv;
        public ImageView iv;

        public MyViewHolder(View view) {
            super(view);
            iv= (ImageView)view.findViewById(R.id.iv_categoryLogo);
            tv = (TextView)view.findViewById(R.id.tv_categoryTitle);
        }
    }
}

