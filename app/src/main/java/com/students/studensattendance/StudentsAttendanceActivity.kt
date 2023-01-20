package com.students.studensattendance

import android.content.IntentFilter
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.util.Log
import android.view.View
import androidx.lifecycle.ViewModelProvider
import com.google.android.material.snackbar.Snackbar
import com.students.studensattendance.`interface`.onCheckNetWorkState
import com.students.studensattendance.adapter.StudentsAdapter
import com.students.studensattendance.apirequest.RetrofitRequest
import com.students.studensattendance.databinding.StudentAttendanceBinding
import com.students.studensattendance.repositroy.StudentRepositroy
import com.students.studensattendance.util.MyReceiver
import com.students.studensattendance.util.NetworkConnection
import com.students.studensattendance.viewmodel.StudentsViewModel
import com.students.studensattendance.viewmodelhelper.StudentViewModelHelper

class StudentsAttendanceActivity : AppCompatActivity(), onCheckNetWorkState {
    private lateinit var  studentsViewModel: StudentsViewModel
    private  lateinit var binding: StudentAttendanceBinding
   //lateinit var checkNetworkConnetion: CheckNetworkConnetion
   private lateinit var myReceiver: MyReceiver
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = StudentAttendanceBinding.inflate(layoutInflater)
        setContentView(binding.root)
       // setContentView(R.layout.student_attendance)
        val request = RetrofitRequest.getInstance()
        val repositroy = StudentRepositroy(request)
        studentsViewModel = ViewModelProvider(this,StudentViewModelHelper(repositroy))[StudentsViewModel::class.java]
        studentsViewModel.getStudentDetails()


        if (NetworkConnection.isInterNetOn(applicationContext)){
            loadingData()
        }else{
            showBar()
        }
        myReceiver= MyReceiver()
        MyReceiver.onReceiveRefresh(this)
      /*  binding.refreshLayout2.setRefreshing(true)
        checkNetworkConnetion= CheckNetworkConnetion(application)
        checkNetworkConnetion.observe(this,{
            if (it){
                loadingData()
            }else{

                showBar()
            }
        })*/

         binding.refreshLayout2.setOnRefreshListener {

             if (NetworkConnection.isInterNetOn(applicationContext)){
                 loadingData()
             }else{
                 showBar()
             }
             binding.refreshLayout2.isRefreshing = false
         }

    }

    private fun showBar() {
        binding.progressBar2.visibility=View.GONE
       // Toast.makeText(applicationContext,"Looks like you are offline, please switch on mobile data or wifi and try again",Toast.LENGTH_LONG).show()
       val snackbar= Snackbar.make(binding.refreshLayout2,"Looks like you are offline, please switch on mobile data or wifi and try again",Snackbar.LENGTH_LONG)
          snackbar.show()
      //  binding.textView9.text="Looks like you are offline, please switch on mobile data or wifi and try again"

        Handler(Looper.getMainLooper()).postDelayed({
            binding.refreshLayout2.isRefreshing = false
         },3000)
    }

    private fun loadingData() {
        binding.refreshLayout2.isRefreshing = true
        val request = RetrofitRequest.getInstance()
        val repositroy = StudentRepositroy(request)
        studentsViewModel = ViewModelProvider(this,StudentViewModelHelper(repositroy))[StudentsViewModel::class.java]
        studentsViewModel.getStudentDetails()
        studentsViewModel.getStudentsData().observe(this) {
            // Log.e("Data list","List: "+ it.get(0).Student_name)
            binding.progressBar2.visibility = View.GONE
            binding.refreshLayout2.setRefreshing(false)
            if (it != null) {
                val adapter = StudentsAdapter()
                adapter.setstudentList(it, applicationContext)
                binding.recyclerView.adapter = adapter
            }
        }

        studentsViewModel.getLoadingStats().observe(this) {
            when (it) {
                true -> binding.progressBar2.visibility = View.VISIBLE
                false -> binding.progressBar2.visibility = View.GONE

            }
        }
    }

    override fun isnetWorkRefresh(b: Boolean) {
        if (b){
            //binding.refreshLayout2.setRefreshing(true)
            loadingData()
        }else{
            Log.e("chchc","false")
            showBar()

        }
    }

    override fun onResume() {
        super.onResume()
        applicationContext.registerReceiver(myReceiver, IntentFilter("android.net.conn.CONNECTIVITY_CHANGE"))
    }

    override fun onPause() {
        super.onPause()
        applicationContext.unregisterReceiver(myReceiver)
    }
}