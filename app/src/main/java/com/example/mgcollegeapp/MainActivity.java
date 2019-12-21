package com.example.mgcollegeapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {


    EditText ed1,ed2;
    Button button,button2,button3;
    String getUname,getPassword;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        ed1=(EditText)findViewById(R.id.uname);
        ed2=(EditText)findViewById(R.id.password);
        button=(Button)findViewById(R.id.loginbutton);
        button2=(Button)findViewById(R.id.regbutton);
        button3=(Button)findViewById(R.id.demobutton);


        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),DemoActivity.class);
                startActivity(intent);
            }
        });



button2.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {

        Intent intent = new Intent(getApplicationContext(),RegisterActivity.class);
        startActivity(intent);

    }
});

    button.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {

            getUname=ed1.getText().toString();
            getPassword=ed2.getText().toString();

            Log.d("username",getUname);
            Log.d("pass",getPassword);

            if(getUname.equals("admin")&&getPassword.equals("12345")){
                Intent intent = new Intent(getApplicationContext(),WelcomeActivity.class);
                startActivity(intent);
            }
            else {
                Toast.makeText(getApplicationContext(),"Invalid Credentials",Toast.LENGTH_LONG).show();
            }



        }
    });



    }
}
