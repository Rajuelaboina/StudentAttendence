package com.students.studensattendance.repositroy

import com.students.studensattendance.apirequest.RetrofitRequest
import com.students.studensattendance.model.Student
import com.students.studensattendance.model.StudentDetail
import retrofit2.Call

class StudentRepositroy constructor(var request: RetrofitRequest) {

    fun getAllStudents(): Call<Student>{
        return request.getStudents()
    }
}