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
    String getName,getRoll,getAdmno,getCollege;
    StudentModel studentModel;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_demo);

         studentModel=new StudentModel();

        ed1=(EditText)findViewById(R.id.readname);
        ed2=(EditText)findViewById(R.id.readrollno);
        ed3=(EditText)findViewById(R.id.readadmno);
        ed4=(EditText)findViewById(R.id.readcollege);

        b=(Button)findViewById(R.id.buttonsubmit);

        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                getName=ed1.getText().toString();
                getRoll=ed2.getText().toString();
                getAdmno=ed3.getText().toString();
                getCollege=ed4.getText().toString();

                studentModel.setName(getName);
                studentModel.setRollno(getRoll);
                studentModel.setAdmno(getAdmno);
                studentModel.setCollege(getCollege);


                String admnoVal= studentModel.getAdmno();
                String roll=studentModel.getRollno();

                Toast.makeText(getApplicationContext(),roll,Toast.LENGTH_LONG).show();






            }
        });

    }
}
