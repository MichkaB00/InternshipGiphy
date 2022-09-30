package com.example.myapplication.model

import com.google.gson.annotations.SerializedName
import com.google.gson.annotations.Expose
import com.example.myapplication.model.Original

class Images {
    @SerializedName("original")
    @Expose
    var original: Original? = null
    override fun toString(): String {
        return "Images{" +
                "original=" + original +
                '}'
    }
}