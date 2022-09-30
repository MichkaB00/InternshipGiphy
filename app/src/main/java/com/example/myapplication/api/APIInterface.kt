package com.example.myapplication.api

import retrofit2.http.GET
import com.example.myapplication.model.ImageGif
import retrofit2.Call

interface APIInterface {
    @get:GET("v1/gifs/trending?api_key=QLoecPd2N8okaKgOqU0KCUx7zbFUB0cZ")
    val photos: Call<ImageGif?>?
}