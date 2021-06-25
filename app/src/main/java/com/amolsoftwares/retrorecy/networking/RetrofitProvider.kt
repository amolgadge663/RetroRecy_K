package com.amolsoftwares.retrorecy.networking

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitProvider {

    private var retrofit: Retrofit? = null

    fun getRetrofit(): Retrofit {
        if (retrofit == null) {
            retrofit = Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl("https://jsonplaceholder.typicode.com/").build()
        }
        return retrofit!!
    }

}