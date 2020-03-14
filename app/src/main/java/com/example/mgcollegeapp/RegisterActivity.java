package com.example.mgcollegeapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;


public class RegisterActivity extends AppCompatActivity {

    Button Regbutton;
    EditText ed1,ed2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        Regbutton=(Button)findViewById(R.id.registerbutton);


   ed1=(EditText)findViewById(R.id.useremail);
   ed2=(EditText)findViewById(R.id.passedit);


   Regbutton.setOnClickListener(new View.OnClickListener() {
       @Override
       public void onClick(View v) {
           Toast.makeText(getApplicationContext(), "Clicked",
                   Toast.LENGTH_SHORT).show();

           String s1=ed1.getText().toString();
           String s2=ed2.getText().toString();

           if(s1.isEmpty()){

               ed1.setError("Enter Password!");
               ed1.requestFocus();

           }

           else{




           }







       }
   });


    }
}
