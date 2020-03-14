package com.example.mgcollegeapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;


public class MainActivity extends AppCompatActivity {


    EditText ed1,ed2;
    Button button,button2,button3,button4,button5,button6;
    String getUname,getPassword;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);




        SharedPreferences preferences=getSharedPreferences("login",MODE_PRIVATE);
        String value= preferences.getString("username",null);

        if(value!=null)
        {
            Intent intent = new Intent(getApplicationContext(),WelcomeActivity.class);
            startActivity(intent);
        }

        ed1=(EditText)findViewById(R.id.uname);
        ed2=(EditText)findViewById(R.id.password);
        button=(Button)findViewById(R.id.loginbutton);
        button2=(Button)findViewById(R.id.regbutton);
        button3=(Button)findViewById(R.id.demobutton);
        button4=(Button)findViewById(R.id.demobuttonView);
        button5=(Button)findViewById(R.id.Smenu);
        button6=(Button)findViewById(R.id.Splay);

        button6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(getApplicationContext(),PlayActivity.class);
                startActivity(intent);

            }
        });

        button5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),StudentMenuActivity.class);
                startActivity(intent);
            }
        });


        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),ViewallActivity.class);
                startActivity(intent);
            }
        });


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

            if(getUname.equals("mgcollege")&&getPassword.equals("12345"))
            {
                SharedPreferences.Editor editor=getSharedPreferences("login",MODE_PRIVATE).edit();
                editor.putString("username",getUname);
                editor.commit();

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
