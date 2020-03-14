package com.example.mgcollegeapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;
import com.squareup.picasso.Picasso;

public class SearchActivity extends AppCompatActivity {

    EditText ed1,ed2,ed3,ed4;
    Button button;
    DatabaseReference reference;
    String admissionNumber;
    ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);
        ed1=(EditText)findViewById(R.id.searchVal);
        ed2=(EditText)findViewById(R.id.searchName);
        ed3=(EditText)findViewById(R.id.searchRoll);
        ed4=(EditText)findViewById(R.id.searchColg);
        button=(Button) findViewById(R.id.studentSearchbtn);
        imageView=(ImageView) findViewById(R.id.ProfPic);


        reference= FirebaseDatabase.getInstance().getReference().child("Students");

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                 admissionNumber=ed1.getText().toString();

               // Toast.makeText(getApplicationContext(),admissionNumber,Toast.LENGTH_LONG).show();

                Query query=reference.orderByChild("admno").equalTo(admissionNumber);

                query.addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {



                        for(DataSnapshot studentDataSnapshot:dataSnapshot.getChildren())
                        {


Toast.makeText(getApplicationContext(),String.valueOf(studentDataSnapshot.getChildrenCount()),Toast.LENGTH_LONG).show();

                            if(studentDataSnapshot.getChildrenCount()!=0){

                                StudentModel studentModel=studentDataSnapshot.getValue(StudentModel.class);

                                String Sname=studentModel.name;
                                String roll=studentModel.rollno;
                                String colg=studentModel.college;
                                String img=studentModel.ProfilePic;
                                ed2.setText(Sname);
                                ed3.setText(roll);
                                ed4.setText(colg);
                                Picasso.with(getApplicationContext()).load(img).into(imageView);

                               // Toast.makeText(getApplicationContext(),studentModel.getName(),Toast.LENGTH_LONG).show();


                            }
                            else {

                                Toast.makeText(getApplicationContext(),"Invalid Admno",Toast.LENGTH_LONG).show();

                                ed2.setText("");
                                ed3.setText("");
                                ed4.setText("");

                            }





                        }


                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {
                        Toast.makeText(getApplicationContext(),"Invalid Admno",Toast.LENGTH_LONG).show();

                    }
                });




            }
        });





    }
}
