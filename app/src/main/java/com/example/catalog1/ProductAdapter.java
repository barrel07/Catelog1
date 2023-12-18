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

public class ProductAdapter extends ArrayAdapter<Productmethod> {

    Context context;

    ArrayList<Productmethod> myproduct;

    public ProductAdapter(@NonNull Context context, ArrayList<Productmethod> myproduct) {
        super(context, R.layout.product_rows, myproduct);
        this.context = context;
        this.myproduct = myproduct;
    }
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.product_rows,null,true);


        TextView myproductname=view.findViewById(R.id.rowproduct_name);
        TextView myproductdiscription=view.findViewById(R.id.rowproduct_discription);
        TextView myproductprice=view.findViewById(R.id.rowproductprice);





        myproductname.setText(myproduct.get(position).getProduct_name());
        myproductdiscription.setText(myproduct.get(position).getProductdiscription());
        myproductprice.setText(myproduct.get(position).getProduct_price());


        return view;
    }
}
