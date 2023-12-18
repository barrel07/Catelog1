package com.example.catalog1;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class ADDproductaActivity extends AppCompatActivity {



    TextView productname,productprice,productQuantity,productdiscription;
    Button productbtn;
    ArrayList<String>getcategory=new ArrayList<>();
    ArrayList<String>getcategoryid=new ArrayList<>();

    AutoCompleteTextView categoryspinner;

    ArrayAdapter<String>adapter;
    String url="https://categlogapp2050.000webhostapp.com/getcategory.php";
    String product_url="https://categlogapp2050.000webhostapp.com/products.php";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_addproducta);


        categoryspinner=findViewById(R.id.autotext);
        displayData();
        adapter=new ArrayAdapter<>(this, android.R.layout.simple_list_item_1,getcategory);
        categoryspinner.setAdapter(adapter);



        productname=findViewById(R.id.addproduct_name);
        productprice=findViewById(R.id.addproductPrice);
        productQuantity=findViewById(R.id.addproductQuantity);
        productdiscription=findViewById(R.id.addproductdiscribtion);
        productbtn=findViewById(R.id.addproductbtn);
        productbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String mycategory_id=categoryspinner.getText().toString();
                String myproductname=productname.getText().toString();
                String myproductprice=productprice.getText().toString();
                String myproductQuantity=productQuantity.getText().toString();
                String myproductdiscription=productdiscription.getText().toString();


                ProgressDialog progressDialog=new ProgressDialog(ADDproductaActivity.this);
                progressDialog.setTitle("plz wait");
                progressDialog.setMessage("plz wait for procces");
                progressDialog.setProgressStyle(progressDialog.STYLE_SPINNER);
                progressDialog.show();




                StringRequest request=new StringRequest(Request.Method.POST, product_url, new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {


                        if (response.equalsIgnoreCase("success")){

                            Toast.makeText(ADDproductaActivity.this, "category add successfully", Toast.LENGTH_SHORT).show();

                        }else {

                            Toast.makeText(ADDproductaActivity.this, "category add un successfully", Toast.LENGTH_SHORT).show();

                        }
                        progressDialog.dismiss();


                    }
                }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        progressDialog.dismiss();

                        Toast.makeText(ADDproductaActivity.this,error.getMessage().toString(), Toast.LENGTH_SHORT).show();

                    }

                }){

                    @Nullable
                    @Override
                    protected Map<String, String> getParams() throws AuthFailureError {

                        progressDialog.show();
                        Map<String,String> parms=new HashMap<>();
                        parms.put("category_id",mycategory_id);
                        parms.put("product_name",myproductname);
                        parms.put("product_price",myproductprice);
                        parms.put("product_quantity",myproductQuantity);
                        parms.put("product_discription",myproductdiscription);



                        return parms;
                    }
                };

                RequestQueue requestQueue= Volley.newRequestQueue(ADDproductaActivity.this);
                requestQueue.add(request);




            }
        });

    }
    void displayData(){

        StringRequest request=new StringRequest(Request.Method.POST, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {

                getcategory.clear();

                try {

                    JSONObject jsonObject = new JSONObject(response);
                    String succes = jsonObject.getString("success");
                    JSONArray jsonArray = jsonObject.getJSONArray("data");

                    if (succes.equals("1")) {

                        for (int i = 0; i < jsonArray.length(); i++) {

                            JSONObject object = jsonArray.getJSONObject(i);


                            String myid = object.getString("cat_id");
                            String myname = object.getString("cat_name");


                            getcategory.add(myname);
                            getcategoryid.add(myid);


                        }

                    }

                } catch (JSONException e) {

                }

            }

        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });

        RequestQueue requestQueue= Volley.newRequestQueue(getApplicationContext());
        requestQueue.add(request);

    }
}