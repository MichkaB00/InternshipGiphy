package com.example.myapplication.models

import com.google.gson.annotations.SerializedName

data class DataArray(
    @SerializedName("data") val data: List<DataObject>
)
