package com.example.mgcollegeapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

public class UpdateActivity extends AppCompatActivity {

    EditText ed1,ed2,ed3,ed4;
    Button button,UpButton,delButton;
    DatabaseReference reference;
    String admissionNumber,newName,newRoll,newCollege;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update);

        reference= FirebaseDatabase.getInstance().getReference().child("Students");

        ed1=(EditText)findViewById(R.id.searchVal);
        ed2=(EditText)findViewById(R.id.searchName);
        ed3=(EditText)findViewById(R.id.searchRoll);
        ed4=(EditText)findViewById(R.id.searchColg);
        button=(Button) findViewById(R.id.studentSearchbtn);
        UpButton=(Button) findViewById(R.id.studentUpdatebtn);
        delButton=(Button) findViewById(R.id.studentDeletebtn);


        delButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                admissionNumber=ed1.getText().toString();
                Query query=reference.orderByChild("admno").equalTo(admissionNumber);

                query.addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                        for (DataSnapshot deleteSnapshot:dataSnapshot.getChildren()){

                            deleteSnapshot.getRef().removeValue();
                            Toast.makeText(getApplicationContext(),"Deleted Successfully",Toast.LENGTH_LONG).show();
                            Intent intent=new Intent(getApplicationContext(),StudentMenuActivity.class);
                            startActivity(intent);

                        }

                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {

                    }
                });


            }
        });

        UpButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


   newName=ed2.getText().toString();
   newRoll=ed3.getText().toString();
   newCollege=ed4.getText().toString();


  Query query= reference.orderByChild("admno").equalTo(admissionNumber);
  query.addListenerForSingleValueEvent(new ValueEventListener() {
      @Override
      public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

          for(DataSnapshot studentSnapshot: dataSnapshot.getChildren()){

              studentSnapshot.getRef().child("name").setValue(newName);
              studentSnapshot.getRef().child("rollno").setValue(newRoll);
              studentSnapshot.getRef().child("college").setValue(newCollege);


          }

          Toast.makeText(getApplicationContext(),"Data Updated Succesfully",Toast.LENGTH_LONG).show();
      }

      @Override
      public void onCancelled(@NonNull DatabaseError databaseError) {

      }
  });



            }
        });


        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                 admissionNumber=ed1.getText().toString();

                Toast.makeText(getApplicationContext(),"TEST 1" + admissionNumber,Toast.LENGTH_LONG).show();

                Query query=reference.orderByChild("admno").equalTo(admissionNumber);

                query.addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {


                        for (DataSnapshot snapshot:dataSnapshot.getChildren()){

                            StudentModel studentModel=snapshot.getValue(StudentModel.class);

                            String Sname=studentModel.name;
                            String roll=studentModel.rollno;
                            String colg=studentModel.college;

                            Toast.makeText(getApplicationContext(),"No value"+Sname,Toast.LENGTH_LONG).show();



//                            if(Sname.isEmpty()){
//                                Toast.makeText(getApplicationContext(),"No value",Toast.LENGTH_LONG).show();
//                            }

                            ed2.setText(Sname);
                            ed3.setText(roll);
                            ed4.setText(colg);
                        }


                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {

                    }
                });


            }
        });


    }
}
