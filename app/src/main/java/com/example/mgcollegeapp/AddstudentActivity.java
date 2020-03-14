package com.example.mgcollegeapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class AddstudentActivity extends AppCompatActivity {

    EditText ed1,ed2,ed3,ed4;
    Button button;
    StudentModel studentModel;
    DatabaseReference reference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_addstudent);
        ed1=(EditText)findViewById(R.id.sname);
        ed2=(EditText)findViewById(R.id.srollno);
        ed3=(EditText)findViewById(R.id.sadmno);
        ed4=(EditText)findViewById(R.id.scollege);
        button=(Button) findViewById(R.id.buttonsubmitstudent);

        reference= FirebaseDatabase.getInstance().getReference().child("Students");

         studentModel=new StudentModel();

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String name=ed1.getText().toString();
                String roll=ed2.getText().toString();
                String admno=ed3.getText().toString();
                String colg=ed4.getText().toString();

                if(name.isEmpty()){
                    ed1.setError("Name field is Mandatory");
                    ed1.requestFocus();
                }
                else if(roll.isEmpty()){
                    ed2.setError("Rollnumber field is Mandatory");
                    ed2.requestFocus();
                }
                else if(colg.isEmpty()){
                    ed4.setError("College field is Mandatory");
                    ed4.requestFocus();
                }
                else if(admno.isEmpty()){
                    ed3.setError("Admission Number field is Mandatory");
                    ed3.requestFocus();
                }
                else{





                    reference.push().setValue(studentModel).addOnCompleteListener(new OnCompleteListener<Void>() {
                        @Override
                        public void onComplete(@NonNull Task<Void> task) {


                            if(task.isSuccessful()){

                                Toast.makeText(getApplicationContext(),"Success",Toast.LENGTH_LONG).show();

                            }
                            else {
                                Toast.makeText(getApplicationContext(),"Error",Toast.LENGTH_LONG).show();

                            }

                        }
                    });


                }







            }
        });
    }
}
