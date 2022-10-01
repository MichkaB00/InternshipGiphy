package com.example.myapplication.adapter

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.myapplication.R
import com.example.myapplication.activity.FullImage
import com.example.myapplication.models.DataObject

class GifsAdapter(private val context: Context, private val gifts: List<DataObject>) : RecyclerView.Adapter<GifsAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(LayoutInflater.from(context).inflate(R.layout.item_layout, parent, false))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val gift = gifts[position]
        Glide.with(context).load(gift.images.original.url).into(holder.imageView)
        holder.imageView.setOnClickListener {
            val intent = Intent(context, FullImage::class.java)
            intent.putExtra("url", gift.images.original.url)
            context.startActivity(intent)
        }
    }

    override fun getItemCount(): Int {
        return gifts.size
    }


    class ViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView) {
        val imageView = itemView.findViewById<ImageView>(R.id.imageView)
    }

}



