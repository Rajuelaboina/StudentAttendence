package com.students.studensattendance.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.students.studensattendance.R
import com.students.studensattendance.databinding.StudentRowBinding
import com.students.studensattendance.model.StudentDetail

class StudentsAdapter : RecyclerView.Adapter<StudentsAdapter.StudentViewHolder>() {

    var studentList = mutableListOf<StudentDetail>()
    lateinit var context: Context
    fun setstudentList(list: List<StudentDetail>, applicationContext: Context) {
        this.studentList = list.toMutableList()
        this.context=applicationContext
        notifyDataSetChanged()
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): StudentViewHolder {
       val inflater = LayoutInflater.from(parent.context)
        val binding = StudentRowBinding.inflate(inflater,parent,false)
        return StudentViewHolder(binding)
    }

    override fun onBindViewHolder(holder: StudentViewHolder, position: Int) {
       holder.bind(studentList[position])
        if (studentList.get(position).status.equals("Present", ignoreCase = true)) {
            holder.binding_.textView8.setTextColor(ContextCompat.getColor(context, R.color.green))
        } else {
            holder.binding_.textView8.setTextColor(ContextCompat.getColor(context, R.color.red))
        }
    }

    override fun getItemCount(): Int {
        return studentList.size
    }
    class StudentViewHolder(binding: StudentRowBinding) : RecyclerView.ViewHolder(binding.root){

         val binding_=binding
        fun bind(studentDetail: StudentDetail){
             binding_.student=studentDetail
        }
    }
}