package com.example.myapplication.adapter

import android.content.Context
import com.example.myapplication.model.DataModel
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.adapter.ImageAdapter.ImageViewHolder
import android.view.ViewGroup
import android.view.LayoutInflater
import com.example.myapplication.R
import com.bumptech.glide.Glide
import android.content.Intent
import android.view.View
import android.widget.ImageView
import com.example.myapplication.activity.FullImage
import java.util.ArrayList

class ImageAdapter(private val context: Context, private val list: ArrayList<DataModel>) :
    RecyclerView.Adapter<ImageViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ImageViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_layout, parent, false)
        return ImageViewHolder(view)
    }

    override fun onBindViewHolder(holder: ImageViewHolder, position: Int) {
        Glide.with(context).load(list[position].imageUrl)
            .into(holder.imageView)
        holder.imageView.setOnClickListener {
            val intent = Intent(context, FullImage::class.java)
            intent.putExtra("url", list[position].imageUrl)
            context.startActivity(intent)
        }
    }

    override fun getItemCount(): Int {
        return list.size
    }

    inner class ImageViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val imageView: ImageView

        init {
            imageView = itemView.findViewById(R.id.imageView)
        }
    }
}