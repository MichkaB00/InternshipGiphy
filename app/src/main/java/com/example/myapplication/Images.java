package com.example.myapplication;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Images {

    @SerializedName("original")
    @Expose
    private Original original;

    public Original getOriginal() {
        return original;
    }

    public void setOriginal(Original original) {
        this.original = original;
    }

    @Override
    public String toString() {
        return "Images{" +
                "original=" + original +
                '}';
    }
}
