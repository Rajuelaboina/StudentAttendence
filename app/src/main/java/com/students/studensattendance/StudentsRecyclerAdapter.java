package com.students.studensattendance;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class StudentsRecyclerAdapter extends RecyclerView.Adapter<StudentsRecyclerAdapter.MyViewHolder> {
    List<StudentInfo> list;
   Context context;
    public StudentsRecyclerAdapter(Context context,List<StudentInfo> list) {
        this.list = list;
        this.context=context;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v= LayoutInflater.from(parent.getContext()).inflate(R.layout.student_row,parent,false);
        return new MyViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.tvname.setText(list.get(position).getStudentName());
        holder.tvdate.setText(list.get(position).getDate());

        holder.tvTime.setText(list.get(position).getTime());
        if (list.get(position).getStatus().equalsIgnoreCase("Present")){
            holder.tvStatus.setTextColor(context.getResources().getColor(R.color.green));
        }else {
            holder.tvStatus.setTextColor(context.getResources().getColor(R.color.red));
        }
        holder.tvStatus.setText(list.get(position).getStatus());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{
       TextView tvname,tvdate,tvTime,tvStatus;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            tvname=itemView.findViewById(R.id.textView2);
            tvdate=itemView.findViewById(R.id.textView4);
            tvTime=itemView.findViewById(R.id.textView6);
            tvStatus=itemView.findViewById(R.id.textView8);
        }
    }
}
