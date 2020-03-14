package com.example.mgcollegeapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class CustomAdapter extends RecyclerView.Adapter<CustomAdapter.MyViewHolder> {

    List<CourseModel> my_List;
    Context context;

    public CustomAdapter(List<CourseModel> my_List, Context context) {
        this.my_List = my_List;
        this.context = context;
    }


    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.my_view,parent,false);


        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {

        CourseModel courseModel=my_List.get(position);
        holder.tv1.setText(courseModel.getCourseTitle());
        holder.tv2.setText(courseModel.getCourseDesc());
        holder.tv3.setText(courseModel.getCourseDate());
        holder.tv4.setText(courseModel.getCourseDuration());
        holder.tv5.setText(courseModel.getCourseVenue());






    }

    @Override
    public int getItemCount() {
        return my_List.size();
    }




    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView tv1,tv2,tv3,tv4,tv5;


        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            tv1=itemView.findViewById(R.id.ctitle);
            tv2=itemView.findViewById(R.id.cdesc);
            tv3=itemView.findViewById(R.id.cdate);
            tv4=itemView.findViewById(R.id.cduration);
            tv5=itemView.findViewById(R.id.cvenue);



        }
    }
}
