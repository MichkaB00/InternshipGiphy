package com.example.myapplication.api

import retrofit2.http.GET
import com.example.myapplication.models.DataArray
import retrofit2.Call

interface APIInterface {

    @GET("v1/gifs/trending?api_key=QLoecPd2N8okaKgOqU0KCUx7zbFUB0cZ")
    fun photos(): Call<DataArray>

}