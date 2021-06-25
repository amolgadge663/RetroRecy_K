package com.amolsoftwares.retrorecy.networking

import android.util.Log
import com.amolsoftwares.retrorecy.Results
import com.amolsoftwares.retrorecy.model.PhotosDataModel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class PhotosService {

    val TAG: String = "Amol"

    fun getPhotosDetails(result: Results) {
        val call: Call<PhotosDataModel> =
            RetrofitProvider.getRetrofit().create(ApiInterface::class.java).photos()

        call.enqueue(object : Callback<PhotosDataModel> {
            override fun onResponse(
                call: Call<PhotosDataModel>,
                response: Response<PhotosDataModel>
            ) {
                val photosDataBody: PhotosDataModel? = response.body()

                val title = response.body()?.get(0)?.title
                Log.d(TAG, "onResponse: $title")
                Log.d(TAG, "onResponseB: " + photosDataBody?.get(0)?.title.toString())

                result.sendResults(photosDataBody!!)
            }

            override fun onFailure(call: Call<PhotosDataModel>, t: Throwable) {
                Log.d(TAG, "onFailure: " + t.message)
            }

        })
    }
}