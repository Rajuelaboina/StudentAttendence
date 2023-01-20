package com.students.studensattendance.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class Student(
   // var StudentDetail : ArrayList<StudentDetail>
    @SerializedName("Student Details")
    val results:List<StudentDetail>
   // var StudentDetail : ArrayList<StudentDetail> = arrayListOf()

)