package com.students.studensattendance;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface APIRequest {

    @POST("students")
    Call<Student> getAllUsers();
}
