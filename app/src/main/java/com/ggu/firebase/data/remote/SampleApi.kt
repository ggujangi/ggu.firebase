package com.ggu.firebase.data.remote

import androidx.lifecycle.LiveData
import com.ggu.firebase.data.model.SampleData
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface SampleApi {

    // LIST USERS
    @GET("users")
    suspend fun getUsers(@Query("page") page: Int): List<SampleData<SampleData.User>>


    // SINGLE USER
    @GET("users/{id}")
    suspend fun getRandomUser(@Path("id") id: Int): SampleData.User


    // LIST <RESOURCE>
    @GET("unknown")
    suspend fun getResources(): List<SampleData<SampleData.Resource>>

    // SINGLE <RESOURCE>
    @GET("unknown/{id}")
    suspend fun getRandomResource(@Path("id") id: Int): SampleData.Resource

}