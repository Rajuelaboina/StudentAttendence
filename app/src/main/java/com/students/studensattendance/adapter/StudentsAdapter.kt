package com.students.studensattendance.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.databinding.DataBindingUtil
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
      /* val inflater = LayoutInflater.from(parent.context)
        val binding = StudentRowBinding.inflate(inflater,parent,false)
        return StudentViewHolder(binding)*/
        return StudentViewHolder(DataBindingUtil.inflate(LayoutInflater.from(parent.context),R.layout.student_row,parent,false))

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

/*class MyAdapter: RecyclerView.Adapter<MyAdapter.MyViewHolder>() {
    var listMovies = ArrayList<Movies>()
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        return MyViewHolder(DataBindingUtil.inflate<RowitemBinding>(LayoutInflater.from(parent.context),R.layout.rowitem,parent,false))
    }

    override fun getItemCount(): Int {
        return listMovies.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        Log.e("onBindViewHolder","response: ${listMovies.get(position).category}")
       holder.bind(listMovies[position])
        with(holder){
            with(listMovies[position]){
                binding.linearLayout.visibility = if (this.expand) View.VISIBLE else View.GONE
                binding.cardLayout.setOnClickListener {
                    this.expand = !this.expand
                    notifyDataSetChanged()
                }
            }
        }
    }

    fun updateList(list: List<Movies>) {
        listMovies= list as ArrayList<Movies>
        notifyDataSetChanged()
    }

    class MyViewHolder(var binding: RowitemBinding) : ViewHolder(binding.root){
            fun bind(moviesItem: Movies) {
               binding.model = moviesItem
            }
    }


}*/
