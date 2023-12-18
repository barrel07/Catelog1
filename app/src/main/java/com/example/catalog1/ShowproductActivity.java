package com.example.catalog1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

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

public class ShowproductActivity extends AppCompatActivity {

    ListView mylist;

    ProductAdapter productAdapter;
    Productmethod productmethod;
    String url="https://categlogapp2050.000webhostapp.com/all_products.php";

    public static ArrayList<Productmethod>productarraylist=new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_showproduct);


        mylist=findViewById(R.id.showproduct_list);
        displayData();
        productAdapter=new ProductAdapter(this,productarraylist);
        mylist.setAdapter(productAdapter);



    }
    void displayData(){

        StringRequest request=new StringRequest(Request.Method.POST, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {

                productarraylist.clear();

                try {

                    JSONObject jsonObject = new JSONObject(response);
                    String succes = jsonObject.getString("sucess");
                    JSONArray jsonArray = jsonObject.getJSONArray("data");

                    if (succes.equals("1")) {

                        for (int i = 0; i < jsonArray.length(); i++) {

                            JSONObject object = jsonArray.getJSONObject(i);


                            String myproduct_id = object.getString("product_id");
                            String mycategory_id = object.getString("category_id");
                            String myproduct_name = object.getString("product_name");
                            String myproduct_price = object.getString("product_price");
                            String myproductQuantity = object.getString("product_quantity");
                            String myproductDiscription = object.getString("product_discription");
                            String myproductImage = object.getString("product_image");


                            productmethod = new Productmethod(myproduct_id,mycategory_id,myproduct_name,myproduct_price,myproductQuantity,myproductDiscription,myproductImage);
                            productarraylist.add(productmethod);
                            productAdapter.notifyDataSetChanged();
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