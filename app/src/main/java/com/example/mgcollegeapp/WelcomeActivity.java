package com.example.mgcollegeapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class WelcomeActivity extends AppCompatActivity {


    EditText ed1,ed2,ed3;
    TextView textView;
    Button button;
    int n1,n2,n3;

    String getNum1,getNum2,Result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);

        ed1=(EditText)findViewById(R.id.num1);
        ed2=(EditText)findViewById(R.id.num2);
        button=(Button)findViewById(R.id.addbut);
        ed3=(EditText)findViewById(R.id.res);
        textView=(TextView)findViewById(R.id.tv);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                getNum1=ed1.getText().toString();
                getNum2=ed2.getText().toString();

                n1=Integer.parseInt(getNum1);
                n2=Integer.parseInt(getNum2);
                n3=n1+n2;
                Result=String.valueOf(n3);


                textView.setVisibility(View.VISIBLE);
                ed3.setVisibility(View.VISIBLE);

                ed3.setText(Result);













            }
        });


    }
}
