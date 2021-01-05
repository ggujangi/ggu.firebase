package com.ggu.firebase.data

import com.ggu.firebase.data.remote.RetrofitBuilder
import com.ggu.firebase.data.remote.SampleApi

class SampleDataSource {
    private val sampleApi : SampleApi = RetrofitBuilder.sampleApi

    suspend fun getUsers(page:Int) = sampleApi.getUsers(page)

    suspend fun getRandomUser(id:Int) = sampleApi.getRandomUser(id)

    suspend fun getResources() = sampleApi.getResources()

    suspend fun getRandomResource(id:Int) = sampleApi.getRandomResource(id)

}