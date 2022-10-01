package com.example.myapplication.models

import com.google.gson.annotations.SerializedName

data class DataObject(
    @SerializedName("images") val images: Images
)