package com.example.mgcollegeapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.textclassifier.TextLinks;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Spinner;
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

public class DemoActivity extends AppCompatActivity {

    Button b;
    ProgressBar progressBar;
    EditText ed1,ed2,ed3,ed4,ed5;
    String getCTitle,getCdescription,getCDate,getCVenue,getCduration;
    String WebApi="https://dummyapilist.herokuapp.com/addcourse";



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_demo);


        ed1=(EditText)findViewById(R.id.readcourse);
        ed2=(EditText)findViewById(R.id.readcoursedescription);
        ed3=(EditText)findViewById(R.id.readDate);
        ed4=(EditText)findViewById(R.id.readvenue);
        ed5=(EditText)findViewById(R.id.readduration);
        progressBar=(ProgressBar)findViewById(R.id.pb);



        b=(Button)findViewById(R.id.buttonsubmit);

        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                progressBar.setVisibility(View.VISIBLE);

                getCTitle=ed1.getText().toString();
                getCdescription=ed2.getText().toString();
                getCDate=ed3.getText().toString();
                getCVenue=ed4.getText().toString();
                getCduration=ed4.getText().toString();


                callApi();



            }
        });

    }

    private void callApi() {

  StringRequest stringRequest=new StringRequest(Request.Method.POST, WebApi,
          new Response.Listener<String>() {
              @Override
              public void onResponse(String response) {
                  progressBar.setVisibility(View.INVISIBLE);

                  ed1.setText("");
                  ed2.setText("");
                  ed4.setText("");
                  ed3.setText("");
                  ed5.setText("");



                  Toast.makeText(getApplicationContext(),response,Toast.LENGTH_LONG).show();
              }
          },
          new Response.ErrorListener() {
              @Override
              public void onErrorResponse(VolleyError error) {
                  progressBar.setVisibility(View.INVISIBLE);


                  Toast.makeText(getApplicationContext(),String.valueOf(error),Toast.LENGTH_LONG).show();


              }
          })
  {

      @Override
      protected Map<String, String> getParams() throws AuthFailureError {

          HashMap<String,String> params=new HashMap<>();
          params.put("courseTitle",getCTitle);
          params.put("courseDescription",getCdescription);
          params.put("courseDuration",getCduration);
          params.put("courseDate",getCDate);
          params.put("courseVenue",getCVenue);


          return params;
      }
  };

        RequestQueue requestQueue= Volley.newRequestQueue(getApplicationContext());
        requestQueue.add(stringRequest);



    }


}
