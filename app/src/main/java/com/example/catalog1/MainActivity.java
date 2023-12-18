package com.example.catalog1;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {


    TextView username, password;
    Button btn1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//
        username = findViewById(R.id.username);
        password = findViewById(R.id.pass_text);
        btn1 = findViewById(R.id.button);
//

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String myusername = username.getText().toString();
                String mypassword = password.getText().toString();

                if (myusername.isEmpty()) {
                    username.requestFocus();
                    username.setError("please enter validate");

                } else if (mypassword.isEmpty()) {
                    password.requestFocus();
                    password.setError("please enter validate");
                } else {
//                    Toast.makeText(MainActivity.this, "validate ok ", Toast.LENGTH_SHORT).show();

//                    AlertDialog.Builder alert=new AlertDialog.Builder(MainActivity.this);
//                    alert.setTitle("login detail");
//                    alert.setMessage("my username is:"+myusername+"\n"+"my password is:"+mypassword);
//                    alert.setCancelable(false);
//
//                    alert.setNegativeButton("cancel", new DialogInterface.OnClickListener() {
//                        @Override
//                        public void onClick(DialogInterface dialog, int which) {
//
//                        }
//                    });
//                    AlertDialog obj=alert.create();
//                    obj.show();

                    ProgressDialog barrel=new ProgressDialog(MainActivity.this);
                    barrel.setTitle("plz wait");
                    barrel.setMessage("please wait process start");

                    barrel.setProgressStyle(ProgressDialog.STYLE_SPINNER);

                    barrel.show();
                    Thread t=new Thread(){

                        @Override
                        public void run(){

                            try {
                                sleep(3000);
                                barrel.dismiss();

                                String adminemail="admin@gmail.com";
                                String adminpassword="Fast1234";

                                if (myusername.equalsIgnoreCase(adminemail)&&mypassword.equalsIgnoreCase(adminpassword)){

                                    Intent next=new Intent(MainActivity.this,Dashboard_activity.class);
                                    startActivity(next);

                                }else {

                                    runOnUiThread(()->{


                                        Toast.makeText(MainActivity.this,"Email or password invalid",Toast.LENGTH_SHORT).show();



                                    });

                                }



                            }catch (InterruptedException I){

                            }

                        }
                    };
                    t.start();

//
//                    barrel.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
//                    barrel.setProgress(0);
//                    barrel.show();
//
//
//                    int totalprogress=100;
//                    Thread t =new Thread(){
//
//                        @Override
//                        public void run() {
//
//                            int startvariable=0;
//                            while(startvariable < totalprogress){
//
//                                try {
//                                    sleep(200);
//                                    startvariable+=5;
//                                    barrel.setProgress(startvariable);
//
//                                }catch(InterruptedException I){
//
//                                }
//
//                            }
//
//                        }
//                    };
//                    t.start();

                }
            }
        });

    }
}