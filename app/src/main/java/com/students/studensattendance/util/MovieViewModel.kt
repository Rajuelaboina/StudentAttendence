package com.phycae.mycompositeexample

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MovieViewModel: ViewModel() {
    val mList = MutableLiveData<List<Movie>>()
    var movieListResponse:List<Movie> by mutableStateOf(listOf())
    fun getMovies(){
       CoroutineScope(Dispatchers.Main).launch {
            /*val call = RertofitRequest.getInstance().create(ApiService::class.java).getAllMovies()
            call.enqueue(object :Callback<List<Movie>>{
                override fun onResponse(call: Call<List<Movie>>, response: Response<List<Movie>>) {
                    mList.postValue(response.body())
                }

                override fun onFailure(call: Call<List<Movie>>, t: Throwable) {
                    mList.postValue(null)
                }

            })*/
           movieListResponse= RertofitRequest.getInstance().create(ApiService::class.java).getAllMovies()

        }
    }
}