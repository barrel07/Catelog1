package com.example.catalog1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class Dashboard_activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);



    }

    public void addcataogriesicon(View view) {
        Intent intent=new Intent(Dashboard_activity.this,Addcatogriesactivity.class);
        startActivity(intent);
    }

    public void addcategoriestitle(View view) {
        Intent intent=new Intent(Dashboard_activity.this,Addcatogriesactivity.class);
        startActivity(intent);
    }


    public void showcataogriesicon(View view) {
        Intent intent=new Intent(Dashboard_activity.this, Showcatogriesactivity.class);
        startActivity(intent);
    }
    public void showcataogriestitle(View view) {
        Intent intent=new Intent(Dashboard_activity.this,Showcatogriesactivity.class);
        startActivity(intent);
    }


    public void addproducticonicon(View view) {
        Intent intent=new Intent(Dashboard_activity.this,ADDproductaActivity.class);
        startActivity(intent);
    }

    public void addproducttitlt(View view) {
        Intent intent=new Intent(Dashboard_activity.this,ADDproductaActivity.class);
        startActivity(intent);
    }

    public void showproducticon(View view) {
        Intent intent=new Intent(Dashboard_activity.this,ShowproductActivity.class);
        startActivity(intent);
    }

    public void showproducttitle(View view) {
        Intent intent=new Intent(Dashboard_activity.this,ShowproductActivity.class);
        startActivity(intent);
    }
}