package com.example.myapplication.activity

import com.example.myapplication.api.APIClient.client
import androidx.appcompat.app.AppCompatActivity
import com.example.myapplication.model.DataModel
import com.example.myapplication.adapter.ImageAdapter
import android.os.Bundle
import android.util.Log
import com.example.myapplication.R
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.GridLayoutManager
import com.example.myapplication.model.Data
import com.example.myapplication.model.ImageGif
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.util.ArrayList
import java.util.function.Consumer

class MainActivity : AppCompatActivity() {
    private var imageGifs: List<Data>? = null
    private val dataModelArrayList = ArrayList<DataModel>()
    private var adapter: ImageAdapter? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val recyclerView = findViewById<RecyclerView>(R.id.recycleView)
        adapter = ImageAdapter(this, dataModelArrayList)
        val manager = GridLayoutManager(this, 2)
        recyclerView.layoutManager = manager
        recyclerView.setHasFixedSize(true)
        recyclerView.adapter = adapter
        imageGifs = ArrayList()

        client.photos?.enqueue(object : Callback<ImageGif?> {
            override fun onResponse(call: Call<ImageGif?>, response: Response<ImageGif?>) {
                if (response.isSuccessful) {
                    imageGifs = response.body()!!.data
                    imageGifs!!.forEach(Consumer { data: Data ->
                        dataModelArrayList.add(
                            DataModel(
                                data.images!!.original!!.url!!
                            )
                        )
                    })
                    adapter!!.notifyDataSetChanged()
                }
            }

            override fun onFailure(call: Call<ImageGif?>, t: Throwable) {
                Log.d("TAG", "onFailure: " + t.message)
            }
        })

    }
}