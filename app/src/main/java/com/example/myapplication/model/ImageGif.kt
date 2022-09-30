package com.example.myapplication.model

import com.google.gson.annotations.SerializedName
import com.google.gson.annotations.Expose

class ImageGif {
    @SerializedName("data")
    @Expose
    var data: List<Data>? = null
    override fun toString(): String {
        return "ImageGif{" +
                "data=" + data +
                '}'
    }
}