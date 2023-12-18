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

public class MainActivity2 extends AppCompatActivity {


    TextView signup_username,signup_password,signup_confirm;

    Button datasignup;

    String url="https://categlogapp2050.000webhostapp.com/adduser.php";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);


        signup_username = findViewById(R.id.Signup_username1);
        signup_password = findViewById(R.id.signup_pass);
        signup_confirm = findViewById(R.id.cnfirmpass_text);
        datasignup = findViewById(R.id.Signupbtn);
        datasignup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {



                String myusername=signup_username.getText().toString();
                String mypassword=signup_password.getText().toString();
                String myconfirmpass=signup_confirm.getText().toString();



                if (myusername.isEmpty()){
                    signup_username.requestFocus();
                    signup_username.setError("please enter validate");

                } else if (mypassword.isEmpty()) {
                    signup_password.setError("please enter validate");
                    signup_password.requestFocus();



                } else if (!mypassword.equals(myconfirmpass)) {

                    signup_confirm.requestFocus();
                    signup_confirm.setError("please enter validate");

                } else {
                    signup_username.setText("");
                    signup_password.setText("");
                    signup_confirm.setText("");

                    ProgressDialog barrel=new ProgressDialog(MainActivity2.this);
                    barrel.setTitle("plz wait");
                    barrel.setMessage("please wait process start");
                    barrel.setProgressStyle(ProgressDialog.STYLE_SPINNER);
                    barrel.show();


                    StringRequest request = new StringRequest(Request.Method.POST, url, new Response.Listener<String>() {
                        @Override
                        public void onResponse(String response) {
                            barrel.dismiss();
                            if (response.equalsIgnoreCase("success")){

                                Toast.makeText(MainActivity2.this,"Add successfully", Toast.LENGTH_SHORT).show();

                            }else {
                                Toast.makeText(MainActivity2.this, "Email or password is invalid", Toast.LENGTH_SHORT).show();
                            }


                        }
                    }, new Response.ErrorListener() {
                        @Override
                        public void onErrorResponse(VolleyError error) {
                            barrel.dismiss();
                            Toast.makeText(MainActivity2.this, error.getMessage(), Toast.LENGTH_SHORT).show();

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


                    RequestQueue requestQueue = Volley.newRequestQueue(MainActivity2.this);
                    requestQueue.add(request);

                }
            }
        });




    }
}