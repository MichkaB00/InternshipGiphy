package com.example.myapplication;


import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    private List<Data> imageGifs;
    private ArrayList<DataModel> dataModelArrayList = new ArrayList<>();
    private TextView textV;

    private RecyclerView recyclerView;
    private ArrayList<Data> list;
    private GridLayoutManager manager;
    private ImageAdapter adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recycleView);
        list = new ArrayList<>();
        adapter = new ImageAdapter(this, dataModelArrayList);
        manager = new GridLayoutManager(this, 2);
        recyclerView.setLayoutManager(manager);
        recyclerView.setHasFixedSize(true);
        recyclerView.setAdapter(adapter);

        imageGifs = new ArrayList<>();


        APIClient.getClient().getPhotos().enqueue(new Callback<ImageGif>() {
            @RequiresApi(api = Build.VERSION_CODES.N)
            @Override
            public void onResponse(Call<ImageGif> call, Response<ImageGif> response) {
                if (response.isSuccessful()) {
                    imageGifs = response.body().getData();
                    imageGifs.forEach(data -> {
                        dataModelArrayList.add(new DataModel(data.getImages().getOriginal().getUrl()));
                    });
                    adapter.notifyDataSetChanged();
                }
            }

            @Override
            public void onFailure(Call<ImageGif> call, Throwable t) {
                Log.d("TAG", "onFailure: " + t.getMessage());
            }
//                Log.d("TAG", String.valueOf(response.code()));
//                imageGifs = response.body().getData();

//                imageGifs.forEach(name -> {
//                    String url = name.getImages().getOriginal().getUrl();
//                    textV.append(url);
//                    Log.d("TAG", url);
//                });
//                Log.d("TAG", String.valueOf(a));
//                textV.setText((CharSequence) a);
//                Log.d("TAG", imageGifs.toString());
        });


    }
}


