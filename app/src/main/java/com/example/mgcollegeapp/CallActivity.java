package com.example.mgcollegeapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.Location;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.tasks.OnSuccessListener;

public class CallActivity extends AppCompatActivity {


    FusedLocationProviderClient fusedLocationProviderClient;
    Button button,button1;
    EditText editText;
    String latitude,longitude;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_call);

        fusedLocationProviderClient= LocationServices.
                getFusedLocationProviderClient(this);



        fusedLocationProviderClient.getLastLocation().
                addOnSuccessListener(this, new
                        OnSuccessListener<Location>() {
                    @Override
                    public void onSuccess(Location location) {

                        if(location!=null){
                            latitude = String.valueOf(location.getLatitude());
                             longitude=String.valueOf(location.getLongitude());

                        }


                    }
                });

        button=(Button)findViewById(R.id.callbtn);
        button1=(Button)findViewById(R.id.fetchlocbtn);
        editText=(EditText)findViewById(R.id.phone);

        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                Toast.makeText(getApplicationContext(),"Lat"+latitude+"long"+longitude,Toast.LENGTH_LONG).show();



            }
        });


        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String mob=editText.getText().toString();

                String message = "Hallo";
                Intent intent=new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse("https://api.whatsapp.com/send?phone="+mob+"&text="+message));
                startActivity(intent);

;

            }
        });
    }
}
