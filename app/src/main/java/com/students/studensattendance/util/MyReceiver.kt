package com.students.studensattendance.util

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import com.students.studensattendance.`interface`.onCheckNetWorkState

class MyReceiver : BroadcastReceiver() {
    companion object{
        lateinit var  onCheckNetWorkState: onCheckNetWorkState
        fun onReceiveRefresh(onCheckNetWorkState: onCheckNetWorkState){
            this.onCheckNetWorkState=onCheckNetWorkState
        }
    }
    override fun onReceive(context: Context, intent: Intent?) {
        if (NetworkConnection.isInterNetOn(context)){
            onCheckNetWorkState.isnetWorkRefresh(true)
        }else{
            onCheckNetWorkState.isnetWorkRefresh(false)

        }
    }
/*
    interface onCheckNetWorkState{
        fun isnetWorkRefresh(b: Boolean)
    }*/
}