package com.example.mgcollegeapp.ui.dashboard;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.example.mgcollegeapp.R;
import com.example.mgcollegeapp.StudentModel;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;

import static android.app.Activity.RESULT_OK;

public class DashboardFragment extends Fragment {

    public String imgPath;

    private DashboardViewModel dashboardViewModel;


    public View onCreateView(@NonNull final LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        dashboardViewModel =
                ViewModelProviders.of(this).get(DashboardViewModel.class);
        View root = inflater.inflate(R.layout.fragment_dashboard, container, false);

        final EditText ed1,ed2,ed3,ed4;
        final Button button,button1;
        final String Imagepath;



        final DatabaseReference reference;

        ed1=(EditText)root.findViewById(R.id.sname);
        ed2=(EditText)root.findViewById(R.id.srollno);
        ed3=(EditText)root.findViewById(R.id.sadmno);
        ed4=(EditText)root.findViewById(R.id.scollege);
        button=(Button)root. findViewById(R.id.buttonsubmitstudent);
        button1=(Button)root. findViewById(R.id.buttonImageUpload);

        reference= FirebaseDatabase.getInstance().getReference().child("Students");




        dashboardViewModel.getText().observe(this, new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {

                StudentModel studentModel;


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
                            StudentModel studentModel;


                            studentModel=new StudentModel( name, roll,  admno, colg, imgPath);


//
                            reference.push().setValue(studentModel).addOnCompleteListener(new OnCompleteListener<Void>() {
                                @Override
                                public void onComplete(@NonNull Task<Void> task) {


                                    if(task.isSuccessful()){

                                        Toast.makeText(getActivity(),"Success",Toast.LENGTH_LONG).show();

                                    }
                                    else {
                                        Toast.makeText(getActivity(),"Error",Toast.LENGTH_LONG).show();

                                    }

                                }
                            });


                        }







                    }
                });


                button1.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {


                        Intent intent=new Intent(Intent.ACTION_GET_CONTENT);
                        intent.setType("image/*");
                        startActivityForResult(intent,1);


                    }
                });






            }
        });
        return root;
    }


    @Override
    public void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(requestCode==1){

            if(resultCode==RESULT_OK){

                Uri fileUri=data.getData();

                StorageReference folder= FirebaseStorage.getInstance().getReference().child("StudentPics");

                String timeStamp=String.valueOf(System.currentTimeMillis());

                final StorageReference filename=folder.child(timeStamp+fileUri.getLastPathSegment());


                filename.putFile(fileUri).addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
                    @Override
                    public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {


                     filename.getDownloadUrl().addOnSuccessListener(new OnSuccessListener<Uri>() {
                         @Override
                         public void onSuccess(Uri uri) {

                             imgPath=String.valueOf(uri);
                             Log.d("Val",imgPath);
                             //Toast.makeText(getActivity(),Imagepath,Toast.LENGTH_LONG).show();
                             Toast.makeText(getActivity(),"successfully Uploaded",Toast.LENGTH_LONG).show();

                         }
                     });




                    }
                });



            }


        }


    }
}