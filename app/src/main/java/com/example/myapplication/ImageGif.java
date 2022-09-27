package com.example.myapplication;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class ImageGif {

    @SerializedName("data")
    @Expose
    private List<Data> data = null;

    public List<Data> getData() {
        return data;
    }

    public void setData(List<Data> data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "ImageGif{" +
                "data=" + data +
                '}';
    }
}

