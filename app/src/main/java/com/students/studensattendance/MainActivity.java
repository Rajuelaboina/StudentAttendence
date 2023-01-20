package com.students.studensattendance;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ProgressBar;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.google.gson.JsonObject;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class MainActivity extends AppCompatActivity {
     List<StudentInfo> list;
     RecyclerView recyclerView;
     SwipeRefreshLayout  swipeRefreshLayout;
    ExecutorService executor;
    ProgressBar progressBar;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        progressBar=findViewById(R.id.progressBar);
        recyclerView=findViewById(R.id.recyclerView2);
        swipeRefreshLayout=findViewById(R.id.refreshLayout);
        UserViewModel  userViewModel= new ViewModelProvider(this).get(UserViewModel.class);

        userViewModel.getListMutableLiveData().observe(this, new Observer<List<StudentInfo>>() {
            @Override
            public void onChanged(List<StudentInfo> studentInfos) {
                Log.e("Mainactivity","DDD: "+studentInfos.get(0).getStudentName());

            }


        });

        /*StringRequest stringRequest= new StringRequest("https://demo.todesign.in/admin/api/students", response -> {
            try {
                JSONObject jsonObject=new JSONObject(response);
               // JSONObject   jb=jsonObject.getJSONObject("channel");

                JSONArray jsonArray=jsonObject.getJSONArray("Student Details");
                Log.e("jsonArray","jsonArray"+ jsonArray);
                for (int i = 0 ; i < jsonArray.length(); i++){
                    JSONObject js=jsonArray.getJSONObject(i);
                    Log.e("js<><><><><<","js: "+" i "+js);


                }



            } catch (JSONException e) {
                e.printStackTrace();
            }
        }, error -> {

        });*/
        /*executor = Executors.newSingleThreadExecutor();
        getStudentData();
        swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {

                getStudentData();
                swipeRefreshLayout.setRefreshing(false);
            }
        });*/

    }

    /*private void getStudentData() {
        executor.execute(new Runnable() {
            @Override
            public void run() {

        JsonObjectRequest jsonObjectRequest= new JsonObjectRequest(Request.Method.POST, "https://demo.todesign.in/admin/api/students", null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                progressBar.setVisibility(View.GONE);
                list=new ArrayList<>();
                Log.e("JSONObject","JSONObject"+ response);
                try {
                    JSONArray jsonArray=response.getJSONArray("Student Details");
                    for (int i=0;i<jsonArray.length();i++){
                        JSONObject jsonObject=jsonArray.getJSONObject(i);

                       *//* list.add(new StudentInfo(
                                jsonObject.getString("Student_name"),
                                jsonObject.getString("date"),
                                jsonObject.getString("time"),
                                jsonObject.getString("status") ));*//*
                        Log.e("JSONObject","JSONObject: "+jsonObject.getString("Student_name"));
                    }

                    StudentsRecyclerAdapter adapter=new StudentsRecyclerAdapter(getApplicationContext(),list);
                    recyclerView.setAdapter(adapter);

                } catch (JSONException e) {
                    e.printStackTrace();
                }

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                progressBar.setVisibility(View.GONE);
            }
        });
        RequestQueue requestQueue= Volley.newRequestQueue(getApplicationContext());
        requestQueue.add(jsonObjectRequest);


            }
        });
    }*/
}