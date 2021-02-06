package com.example.marsrealestate.overview

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.marsrealestate.network.MarsApi
import retrofit2.Call
import retrofit2.Response

class OverviewViewModel : ViewModel() {

    private val _response = MutableLiveData<String>()

    val response: LiveData<String>
        get() = _response


    init {
        getMarsRealEstateProperties()
    }

    private fun getMarsRealEstateProperties() {
        MarsApi.retrofitService.getProperties().enqueue(object : retrofit2.Callback<String> {
            override fun onResponse(call: Call<String>, response: Response<String>) {
                if (response.isSuccessful) _response.value = response.body()
            }

            override fun onFailure(call: Call<String>, t: Throwable) {
                _response.value = "Failure" + t.message
            }

        })
    }
}
