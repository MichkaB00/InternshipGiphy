package com.example.myapplication.model

import com.google.gson.annotations.SerializedName
import com.google.gson.annotations.Expose


data class Data (
    @SerializedName("id")
    @Expose
    var id: String? = null,
    @SerializedName("images")
    @Expose
    var images: Images? = null
)