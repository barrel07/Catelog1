package com.example.catalog1;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;

public class Category_adapter extends ArrayAdapter<Category_Method> {

    Context context;
    ArrayList<Category_Method>mycategory;

    public Category_adapter(@NonNull Context context,ArrayList<Category_Method>mycategory) {
        super(context, R.layout.category_rows,mycategory);
        this.context=context;
        this.mycategory=mycategory;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.category_rows,null,true);
        TextView myuser_id=view.findViewById(R.id.row_category_id);
        TextView myuser_name=view.findViewById(R.id.row_category_name);


        myuser_id.setText(mycategory.get(position).getUser_id());
        myuser_name.setText(mycategory.get(position).getUser_name());


        return view;
    }
}
