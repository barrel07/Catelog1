package com.example.catalog1;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import java.util.HashMap;
import java.util.Map;

public class UserloginActivity3 extends AppCompatActivity {


    TextView btn2;
    TextView username,password;
    Button loginbtn;

    String url="https://categlogapp2050.000webhostapp.com/userlogin.php";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_userlogin3);

        btn2=findViewById(R.id.createbtn_userlogin);

        username=findViewById(R.id.username_userlogin);
        password=findViewById(R.id.login_pass);
        loginbtn=findViewById(R.id.buttonsignin);
        loginbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {




                String myusername=username.getText().toString();
                String mypassword=password.getText().toString();




                if (myusername.isEmpty()){
                    username.requestFocus();
                    username.setError("please enter validate");

                } else if (mypassword.isEmpty()) {
                    password.setError("please enter validate");
                    password.requestFocus();



                }else {

                    username.setText("");
                    password.setText("");

                    ProgressDialog barrel=new ProgressDialog(UserloginActivity3.this);
                    barrel.setTitle("plz wait");
                    barrel.setMessage("please wait process start");
                    barrel.setProgressStyle(ProgressDialog.STYLE_SPINNER);
                    barrel.show();



                    StringRequest request = new StringRequest(Request.Method.POST, url, new Response.Listener<String>() {
                        @Override
                        public void onResponse(String response) {
                            barrel.dismiss();

                            if (response.equalsIgnoreCase("ok")){

                               Intent intent=new Intent(UserloginActivity3.this,Userdashboardactivity.class);
                               startActivity(intent);

                            }else{
                                Toast.makeText(UserloginActivity3.this, "email or password invalid", Toast.LENGTH_SHORT).show();
                            }
//
                        }
                    }, new Response.ErrorListener() {
                        @Override
                        public void onErrorResponse(VolleyError error) {
                            barrel.dismiss();
                            Toast.makeText(UserloginActivity3.this, error.getMessage(), Toast.LENGTH_SHORT).show();

                        }
                    }) {

                        @Nullable
                        @Override
                        protected Map<String, String> getParams() throws AuthFailureError {
                            barrel.show();
                            Map<String, String> parms = new HashMap<>();
                            parms.put("user_name", myusername);
                            parms.put("user_password", mypassword);

                            return parms;
                        }
                    };


                    RequestQueue requestQueue = Volley.newRequestQueue(UserloginActivity3.this);
                    requestQueue.add(request);

                }
            }
        });

        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(UserloginActivity3.this,MainActivity2.class);
                startActivity(intent);
            }
        });



    }
}