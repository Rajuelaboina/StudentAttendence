package com.students.studensattendance.apirequest

import com.students.studensattendance.model.Student
import com.students.studensattendance.model.StudentDetail
import retrofit2.Call
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.POST

interface RetrofitRequest {
    @POST("students")
    fun getStudents(): Call<Student>

    companion object{
        val base_url: String = "https://demo.todesign.in/admin/api/"
        var retrofitRequest: RetrofitRequest?=null
        fun getInstance() : RetrofitRequest{
           if (retrofitRequest==null){
               val retrofit = Retrofit.Builder()
                   .baseUrl(base_url)
                   .addConverterFactory(GsonConverterFactory.create())
                   .build()
               retrofitRequest = retrofit.create(RetrofitRequest::class.java)
           }
            return retrofitRequest!!
        }

    }
}