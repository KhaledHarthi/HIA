package com.khaledharthi.harajinterviewapp;

import android.content.res.AssetManager;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.khaledharthi.harajinterviewapp.Adapters.MainPostAdapter;
import com.khaledharthi.harajinterviewapp.Models.PostItem;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ArrayList<PostItem> list;
    RecyclerView recyclerView;
    MainPostAdapter adapter;

    @Override
    protected void onResume() {
        super.onResume();
        // Configure RecyclerView layout style
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        // Attach adapter to RecyclerView
        recyclerView.setAdapter(adapter);
        // Load and shape data from JSON file.
        list = Utility.loadData(this);
        // Construct an RecyclerView adapter.
        adapter.setData(list);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.mainRV);
        adapter = new MainPostAdapter(this, recyclerView);
    }

}
