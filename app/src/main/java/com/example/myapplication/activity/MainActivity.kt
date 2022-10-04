package com.example.myapplication.activity

import com.example.myapplication.api.APIClient.client
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.myapplication.R
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.GridLayoutManager
import com.example.myapplication.adapter.GifsAdapter
import com.example.myapplication.databinding.ActivityMainBinding
import com.example.myapplication.models.DataArray
import com.example.myapplication.models.DataObject
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class MainActivity : AppCompatActivity() {



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val recyclerView = findViewById<RecyclerView>(R.id.recycleView)

        val gift = ArrayList<DataObject>()
        val adapter1 = GifsAdapter(this, gift)

        recyclerView.adapter = adapter1
        recyclerView.setHasFixedSize(true)
        recyclerView.layoutManager = GridLayoutManager(this, 2)


        client.photos1().enqueue(object : Callback<DataArray> {
            override fun onResponse(call: Call<DataArray>, response: Response<DataArray>) {
                if (response.isSuccessful) {
                    val data = response.body()
                    gift.addAll(data?.data!!)
                    adapter1.notifyDataSetChanged()
                }
            }

            override fun onFailure(call: Call<DataArray>, t: Throwable) {
                Log.d("TAG", "onFailure: " + t.message)
            }
        })


    }
}