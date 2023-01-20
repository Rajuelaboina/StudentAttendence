package com.students.studensattendance;

import android.os.Handler;
import android.os.Looper;
import android.util.Log;

import androidx.lifecycle.MutableLiveData;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class UserRepositroy {
  MutableLiveData<List<StudentInfo>> list=new MutableLiveData<List<StudentInfo>>();
  Retrofit retrofitRequest;
  APIRequest apiRequest;
    ExecutorService executor;
    Handler handler;
    public UserRepositroy() {
        retrofitRequest=RetrofitRequest.getInstance();
        apiRequest=retrofitRequest.create(APIRequest.class);
        executor = Executors.newSingleThreadExecutor();
        handler = new Handler(Looper.getMainLooper());
        getAllUsers();
    }
    public void getAllUsers(){
        executor.execute(new Runnable() {
            @Override
            public void run() {
              //  Call<Student> studentCall= apiRequest.getAllUsers();

                apiRequest.getAllUsers().enqueue(new Callback<Student>() {
                    @Override
                    public void onResponse(Call<Student> call, Response<Student> response) {

                        Log.e("DDDDDDDDDDDD","DDD: "+response.body().getStudentDetails());
                       list.setValue(response.body().getStudentDetails());

                    }

                    @Override
                    public void onFailure(Call<Student> call, Throwable t) {

                    }
                });
            }
        });

    }

    public MutableLiveData<List<StudentInfo>> getUserList(){
        return list;
    }
}

