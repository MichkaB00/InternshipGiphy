package com.example.myapplication.model

import com.google.gson.annotations.SerializedName
import com.google.gson.annotations.Expose
import com.example.myapplication.model.Original


data class Images(
    @SerializedName("original")
    @Expose
    var original: Original? = null
)