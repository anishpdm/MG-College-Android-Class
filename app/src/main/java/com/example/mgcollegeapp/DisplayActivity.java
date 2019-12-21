package com.example.mgcollegeapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class DisplayActivity extends AppCompatActivity {


    TextView textView;
    String getValue;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display);


        textView=(TextView)findViewById(R.id.displayname);

        Intent intent=getIntent();
        getValue=intent.getStringExtra("myname");

        textView.setText(getValue);


    }
}
