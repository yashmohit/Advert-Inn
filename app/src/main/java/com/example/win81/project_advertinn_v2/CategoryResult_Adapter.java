package com.example.win81.project_advertinn_v2;

import android.icu.util.ULocale;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.win81.project_advertinn_v2.dto.CategoryName;

import java.util.List;

public class CategoryResult_Adapter extends RecyclerView.Adapter<CategoryResult_Adapter.MyViewHolder> {

    private List<CategoryName> categoryList;

    public CategoryResult_Adapter(List<CategoryName> categoryList) {
        this.categoryList = categoryList;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.showcategory, parent, false);

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
            iv= (ImageView)view.findViewById(R.id.imageView);
            tv = (TextView)view.findViewById(R.id.info_text);
        }
    }
}

