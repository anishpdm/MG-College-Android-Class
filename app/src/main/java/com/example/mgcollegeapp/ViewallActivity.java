package com.example.mgcollegeapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

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
import java.util.List;

public class ViewallActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    List<CourseModel> my_List;
    RecyclerView.Adapter adapter;

String ApiUrl="https://dummyapilist.herokuapp.com/getcourses";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_viewall);


        my_List=new ArrayList<>();

        recyclerView=(RecyclerView)findViewById(R.id.recycler);
        recyclerView.setHasFixedSize(true);

        int numOfColums=1;
        recyclerView.setLayoutManager(new GridLayoutManager(this,numOfColums));



        callApi();

    }

    private void callApi() {


    StringRequest stringRequest=new StringRequest(Request.Method.GET, ApiUrl,
            new Response.Listener<String>() {
                @Override
                public void onResponse(String response) {

//                    Log.d("ViewAll",response);
                    Toast.makeText(getApplicationContext(),response,Toast.LENGTH_LONG).show();
                    try {
                        JSONArray jsonArray=new JSONArray(response);


                        for (int i = 0; i < jsonArray.length(); i++) {
                            JSONObject object = jsonArray.getJSONObject(i);
                            String courseTitle = object.getString("courseTitle");
                            String courseVenue = object.getString("courseVenue");
                            String courseDuration = object.getString("courseDuration");
                            String courseDescription = object.getString("courseDescription");
                            String courseDate = object.getString("courseDate");


                            CourseModel model = new CourseModel(courseTitle, courseDescription, courseDuration, courseDate,courseVenue);
                            my_List.add(model);
                        }

                        adapter = new CustomAdapter(my_List, getApplicationContext());
                        recyclerView.setAdapter(adapter);



                    } catch (JSONException e) {

                        Toast.makeText(getApplicationContext(),String.valueOf(e),Toast.LENGTH_LONG).show();

                        e.printStackTrace();
                    }


                }
            },
            new Response.ErrorListener() {
                @Override
                public void onErrorResponse(VolleyError error) {

                }
            });


        RequestQueue requestQueue= Volley.newRequestQueue(getApplicationContext());
        requestQueue.add(stringRequest);


    }
}
