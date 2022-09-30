package com.example.myapplication.model

import com.google.gson.annotations.SerializedName
import com.google.gson.annotations.Expose

class Original {
    @SerializedName("height")
    @Expose
    var height: String? = null

    @SerializedName("width")
    @Expose
    var width: String? = null

    @SerializedName("url")
    @Expose
    var url: String? = null
    override fun toString(): String {
        return "Original{" +
                "height='" + height + '\'' +
                ", width='" + width + '\'' +
                ", url='" + url + '\'' +
                '}'
    }
}