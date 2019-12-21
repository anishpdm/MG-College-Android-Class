package com.example.mgcollegeapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class DemoActivity extends AppCompatActivity {

    Button b;
    EditText ed1,ed2,ed3,ed4;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_demo);
        ed1=(EditText)findViewById(R.id.readname);
        ed2=(EditText)findViewById(R.id.readrollno);
        ed3=(EditText)findViewById(R.id.readadmno);
        ed4=(EditText)findViewById(R.id.readcollege);

        b=(Button)findViewById(R.id.buttonsubmit);

        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {



            }
        });

    }
}
