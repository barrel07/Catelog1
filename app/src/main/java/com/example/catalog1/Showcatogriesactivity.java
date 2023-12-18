package com.example.catalog1;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
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

public class Showcatogriesactivity extends AppCompatActivity {
    ListView mylist;
    Category_adapter categoryAdapter;
    Category_Method categoryMethod;

    String url="https://categlogapp2050.000webhostapp.com/all_categories.php";
    String deleteurl="https://categlogapp2050.000webhostapp.com/Delete.php";

    public static ArrayList<Category_Method>myarraylist=new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_showcatogriesactivity);

        mylist=findViewById(R.id.showcatagry_list);
        displayData();
        categoryAdapter=new Category_adapter(this,myarraylist);
        mylist.setAdapter(categoryAdapter);
        mylist.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                AlertDialog.Builder builder=new AlertDialog.Builder(view.getContext());
                builder.setTitle(myarraylist.get(position).getUser_name());
                CharSequence items[] ={"Edit record","Delete record"};
                builder.setItems(items, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog,int which) {

                        switch (which){

                            case 0:
                                Intent intent=new Intent(Showcatogriesactivity.this,Editcategory_activity.class);
                                intent.putExtra("cat_id",position);
                                startActivity(intent);

                                break;

                            case 1:

                                deleteData(myarraylist.get(position).getUser_id());
                                Toast.makeText(Showcatogriesactivity.this, "Delete success", Toast.LENGTH_SHORT).show();
                                break;

                        }
                    }
                });
                AlertDialog alertDialog=builder.create();
                alertDialog.show();

            }
        });


    }
    void displayData(){

        StringRequest request=new StringRequest(Request.Method.POST, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {

                myarraylist.clear();

                try {

                    JSONObject jsonObject = new JSONObject(response);
                    String succes = jsonObject.getString("sucess");
                    JSONArray jsonArray = jsonObject.getJSONArray("data");

                    if (succes.equals("1")) {

                        for (int i = 0; i < jsonArray.length(); i++) {

                            JSONObject object = jsonArray.getJSONObject(i);


                            String myid = object.getString("cat_id");
                            String myname = object.getString("cat_name");


                            categoryMethod = new Category_Method(myid, myname);
                            myarraylist.add(categoryMethod);
                            categoryAdapter.notifyDataSetChanged();
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
    void deleteData(String id){

        int cat_id=Integer.parseInt(id);
        ProgressDialog progressDialog=new ProgressDialog(Showcatogriesactivity.this);
        progressDialog.setTitle("plz wait");
        progressDialog.setMessage("plz wait for procces");
        progressDialog.setProgressStyle(progressDialog.STYLE_SPINNER);
        progressDialog.show();


        StringRequest request=new StringRequest(Request.Method.POST, deleteurl, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {


                if (response.equalsIgnoreCase("sucess")){
                    displayData();
                    Toast.makeText(Showcatogriesactivity.this, "category add successfully", Toast.LENGTH_SHORT).show();

                }else {

                    Toast.makeText(Showcatogriesactivity.this, "category add un successfully", Toast.LENGTH_SHORT).show();

                }
                progressDialog.dismiss();


            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                progressDialog.dismiss();

                Toast.makeText(Showcatogriesactivity.this,error.getMessage().toString(), Toast.LENGTH_SHORT).show();

            }

        }){

            @Nullable
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {

                progressDialog.show();
                Map<String,String> parms=new HashMap<>();
                parms.put("cat_id", String.valueOf(cat_id));

                return parms;
            }
        };

        RequestQueue requestQueue= Volley.newRequestQueue(Showcatogriesactivity.this);
        requestQueue.add(request);






    }
}