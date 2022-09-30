package com.example.myapplication.model

import com.google.gson.annotations.SerializedName
import com.google.gson.annotations.Expose

class Data {
    @SerializedName("id")
    @Expose
    var id: String? = null

    @SerializedName("images")
    @Expose
    var images: Images? = null
    override fun toString(): String {
        return "Data{" +
                "id='" + id + '\'' +
                ", images=" + images +
                '}'
    }
}