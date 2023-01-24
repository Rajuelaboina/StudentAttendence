package com.students.studensattendance.apirequest

import com.students.studensattendance.model.Student
import retrofit2.Call
import retrofit2.http.POST

interface Api {
    @POST("students")
    fun getStudents(): Call<Student>
}