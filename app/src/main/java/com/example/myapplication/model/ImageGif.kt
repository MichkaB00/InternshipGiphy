package com.example.myapplication.model

import com.google.gson.annotations.SerializedName
import com.google.gson.annotations.Expose


data class ImageGif(
    @SerializedName("data")
    @Expose
    var data: List<Data>? = null
)