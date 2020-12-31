package com.ggu.firebase.data.remote

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitBuilder {

    private const val SAMPLE_URL = "https://reqres.in/api/"

    private fun getRetrofit(): Retrofit {
        return Retrofit.Builder()
            .baseUrl(SAMPLE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    val sampleApi: SampleApi = getRetrofit().create(SampleApi::class.java)

}