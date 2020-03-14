package com.example.mgcollegeapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class PlayActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_play);
        Toast.makeText(getApplicationContext(),"Create",Toast.LENGTH_LONG).show();

    }


    @Override
    protected void onStart() {
        super.onStart();
        Toast.makeText(getApplicationContext(),"Start",Toast.LENGTH_LONG).show();

    }

    @Override
    protected void onStop() {
        super.onStop();
        Toast.makeText(getApplicationContext(),"Stop",Toast.LENGTH_LONG).show();

    }

    @Override
    protected void onDestroy() {
        Toast.makeText(getApplicationContext(),"Destroyed",Toast.LENGTH_LONG).show();

        super.onDestroy();

    }
}
