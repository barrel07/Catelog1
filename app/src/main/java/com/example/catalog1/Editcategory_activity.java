package com.example.catalog1;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
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

public class Editcategory_activity extends AppCompatActivity {
    EditText editcategory;
    Button updatetext;
    String url="https://categlogapp2050.000webhostapp.com/Update.php";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_editcategory);



        editcategory=findViewById(R.id.Editaddcategory_name);

        Intent intent=getIntent();

        int cat_id=intent.getExtras().getInt("cat_id");

        String catid=Showcatogriesactivity.myarraylist.get(cat_id).getUser_id();

        editcategory.setText(Showcatogriesactivity.myarraylist.get(cat_id).getUser_name());

        updatetext=findViewById(R.id.Editaddcategorybtn);

        updatetext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String cat_name=editcategory.getText().toString();

                ProgressDialog progressDialog=new ProgressDialog(Editcategory_activity.this);
                progressDialog.setTitle("plz wait");
                progressDialog.setMessage("plz wait for procces");
                progressDialog.setProgressStyle(progressDialog.STYLE_SPINNER);
                progressDialog.show();


                StringRequest request=new StringRequest(Request.Method.POST, url, new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {


                        if (response.equalsIgnoreCase("sucess")){

                            Toast.makeText(Editcategory_activity.this, "category Edit successfully", Toast.LENGTH_SHORT).show();

                            Intent intent1=new Intent(Editcategory_activity.this,Showcatogriesactivity.class);
                            startActivity(intent1);
                        }else {

                            Toast.makeText(Editcategory_activity.this, "category Edit un successfully", Toast.LENGTH_SHORT).show();

                        }
                        progressDialog.dismiss();


                    }
                }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        progressDialog.dismiss();

                        Toast.makeText(Editcategory_activity.this,error.getMessage().toString(), Toast.LENGTH_SHORT).show();

                    }

                }){

                    @Nullable
                    @Override
                    protected Map<String, String> getParams() throws AuthFailureError {

                        progressDialog.show();
                        Map<String,String> parms=new HashMap<>();
                        parms.put("cat_name",cat_name);
                        parms.put("cat_id",catid);

                        return parms;
                    }
                };

                RequestQueue requestQueue= Volley.newRequestQueue(Editcategory_activity.this);
                requestQueue.add(request);


            }
        });
    }
}