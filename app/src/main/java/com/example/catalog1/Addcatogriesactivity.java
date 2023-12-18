package com.example.catalog1;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;


import android.app.ProgressDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
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

public class Addcatogriesactivity extends AppCompatActivity {

    EditText cat_name;
    Button btnadd;

    String url="https://categlogapp2050.000webhostapp.com/addcategory.php";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_addcatogriesactivity);

        cat_name=findViewById(R.id.addcategory_name);
        btnadd=findViewById(R.id.addcategorybtn);
        btnadd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                ProgressDialog progressDialog=new ProgressDialog(Addcatogriesactivity.this);
                progressDialog.setTitle("plz wait");
                progressDialog.setMessage("plz wait for procces");
                progressDialog.setProgressStyle(progressDialog.STYLE_SPINNER);
                progressDialog.show();


                String mycatname=cat_name.getText().toString();
                cat_name.setText("");

                StringRequest request=new StringRequest(Request.Method.POST, url, new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {


                        if (response.equalsIgnoreCase("success")){

                            Toast.makeText(Addcatogriesactivity.this, "category add successfully", Toast.LENGTH_SHORT).show();

                        }else {

                            Toast.makeText(Addcatogriesactivity.this, "category add un successfully", Toast.LENGTH_SHORT).show();

                        }
                        progressDialog.dismiss();


                    }
                }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        progressDialog.dismiss();

                        Toast.makeText(Addcatogriesactivity.this,error.getMessage().toString(), Toast.LENGTH_SHORT).show();

                    }

                }){

                    @Nullable
                    @Override
                    protected Map<String, String> getParams() throws AuthFailureError {

                        progressDialog.show();
                        Map<String,String> parms=new HashMap<>();
                        parms.put("cat_name",mycatname);

                        return parms;
                    }
                };

                RequestQueue requestQueue= Volley.newRequestQueue(Addcatogriesactivity.this);
                requestQueue.add(request);


            }
        });


    }
   }