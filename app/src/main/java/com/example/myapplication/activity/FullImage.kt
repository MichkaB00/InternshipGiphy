package com.example.myapplication.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import com.example.myapplication.R
import com.bumptech.glide.Glide

class FullImage : AppCompatActivity() {
    private var imageView: ImageView? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_full_image)
        imageView = findViewById(R.id.fullImage)
        val url = intent.getStringExtra("url")
        Glide.with(this).load(url).into(imageView!!)
    }
}