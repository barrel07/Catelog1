package com.example.catalog1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class DailoginfoActivity3 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dailoginfo3);
    }


    public void infoicon(View view) {
        Intent intent=new Intent(DailoginfoActivity3.this,MainActivity.class);
        startActivity(intent);
    }

    public void infotittle(View view) {
        Intent intent=new Intent(DailoginfoActivity3.this,MainActivity.class);
        startActivity(intent);
    }
    public void usericon(View view) {
        Intent intent=new Intent(DailoginfoActivity3.this,UserloginActivity3.class);
        startActivity(intent);
    }
    public void usertittle(View view) {
        Intent intent=new Intent(DailoginfoActivity3.this,UserloginActivity3.class);
        startActivity(intent);
    }


}