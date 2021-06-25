package com.amolsoftwares.retrorecy

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.amolsoftwares.retrorecy.adapter.PhotosAdapter
import com.amolsoftwares.retrorecy.model.PhotosDataModel
import com.amolsoftwares.retrorecy.networking.PhotosService

class MainActivity : AppCompatActivity(), Results {

    lateinit var adapter: PhotosAdapter
    lateinit var recyclerView: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        PhotosService().getPhotosDetails(this)

    }

    override fun sendResults(photos: PhotosDataModel) {

        adapter = PhotosAdapter(this, photos)
        recyclerView = findViewById(R.id.recyclerView)
        recyclerView.adapter = adapter
        recyclerView.layoutManager = LinearLayoutManager(this)

    }
}

interface Results {
    fun sendResults(photos: PhotosDataModel)
}