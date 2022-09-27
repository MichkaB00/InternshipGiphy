package com.example.myapplication.api;

import com.example.myapplication.model.ImageGif;

import retrofit2.Call;
import retrofit2.http.GET;


public interface APIInterface {

    @GET("v1/gifs/trending?api_key=QLoecPd2N8okaKgOqU0KCUx7zbFUB0cZ")
    Call<ImageGif> getPhotos();

}
