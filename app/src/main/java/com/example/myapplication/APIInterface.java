package com.example.myapplication;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;


public interface APIInterface {

    @GET("v1/gifs/trending?api_key=QLoecPd2N8okaKgOqU0KCUx7zbFUB0cZ")
    Call<ImageGif> getPhotos();

}
