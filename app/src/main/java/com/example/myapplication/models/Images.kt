package com.example.myapplication.models

import com.google.gson.annotations.SerializedName

data class Images(
    @SerializedName("original") val original: Original
)