package com.amolsoftwares.retrorecy.networking

import com.amolsoftwares.retrorecy.model.PhotosDataModel
import retrofit2.Call
import retrofit2.http.GET

interface ApiInterface {

    @GET("photos")
    fun photos(): Call<PhotosDataModel>
}