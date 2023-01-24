package com.students.studensattendance.viewmodel

import android.util.Log
import androidx.databinding.BaseObservable
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.students.studensattendance.apirequest.RetrofitInstance
import com.students.studensattendance.model.Student
import com.students.studensattendance.model.StudentDetail
import com.students.studensattendance.repositroy.StudentRepositroy
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.launch
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class StudentsViewModel : ViewModel() {
     val stList = MutableLiveData<List<StudentDetail>>()
     val loading = MutableLiveData<Boolean>()
    fun getStudentDetails(){
        loading.postValue(true)

        CoroutineScope(IO).launch {
            RetrofitInstance.api.getStudents()
             .enqueue(object : Callback<Student>{
                override fun onResponse(call: Call<Student>, response: Response<Student>) {
                    Log.e("Data list","response: "+ response.body())
                    stList.postValue(response.body()?.results)
                    loading.postValue(false)
                   // Log.e("Data list","response: "+ stList)

                }

                override fun onFailure(call: Call<Student>, t: Throwable) {
                    Log.e("Data list","response: "+ t.message)
                    stList.postValue(null)
                    loading.postValue(false)
                }

            })
        }

    }

    fun getStudentsData():  MutableLiveData<List<StudentDetail>>{
        return stList
    }
    fun getLoadingStats(): MutableLiveData<Boolean>{
        return loading
    }
}
/*
class StudentsViewModel(val repositroy: StudentRepositroy) : ViewModel() {
    val stList = MutableLiveData<List<StudentDetail>>()
    val loading = MutableLiveData<Boolean>()
    fun getStudentDetails(){
        loading.postValue(true)
        val res = repositroy.getAllStudents()
        CoroutineScope(IO).launch {
            res.enqueue(object : Callback<Student>{
                override fun onResponse(call: Call<Student>, response: Response<Student>) {
                    Log.e("Data list","response: "+ response.body())
                    stList.postValue(response.body()?.results)
                    loading.postValue(false)
                    Log.e("Data list","response: "+ stList)
                }

                override fun onFailure(call: Call<Student>, t: Throwable) {
                    Log.e("Data list","response: "+ t.message)
                    stList.postValue(null)
                    loading.postValue(false)
                }

            })
        }

    }

    fun getStudentsData():  MutableLiveData<List<StudentDetail>>{
        return stList
    }
    fun getLoadingStats(): MutableLiveData<Boolean>{
        return loading
    }
}*/
