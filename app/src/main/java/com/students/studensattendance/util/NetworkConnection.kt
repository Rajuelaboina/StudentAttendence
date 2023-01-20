package com.students.studensattendance.util

import android.content.Context
import android.net.ConnectivityManager
import android.net.NetworkCapabilities
import android.os.Build

@Suppress("DEPRECATION")
class NetworkConnection {

    companion object{

        fun isInterNetOn( context: Context): Boolean{
            val connectivityManager = context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                val network = connectivityManager.activeNetwork?: return false
                val activeNetwork = connectivityManager.getNetworkCapabilities(network)?: return false
                return when{
                    activeNetwork.hasTransport(NetworkCapabilities.TRANSPORT_WIFI) -> true
                    activeNetwork.hasTransport(NetworkCapabilities.TRANSPORT_CELLULAR) -> true
                    else -> false
                }
            } else {
                val netWorkInfo = connectivityManager.activeNetworkInfo?: return false
                return netWorkInfo.isConnected
            }
        }
    }
}