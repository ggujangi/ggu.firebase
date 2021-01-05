package com.ggu.firebase.data

import kotlin.math.roundToInt

class SampleRepository(private val dataSource: SampleDataSource = SampleDataSource()) {

    suspend fun getUsers(page:Int) = dataSource.getUsers(page)

    suspend fun getRandomUser() = dataSource.getRandomUser(((Math.random()*1000)%12).roundToInt())

    suspend fun getResources(page:Int) = dataSource.getResources()

    suspend fun getRandomResource() = dataSource.getRandomResource(((Math.random()*1000)%12).roundToInt())

}