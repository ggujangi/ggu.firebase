package com.ggu.firebase.ui.sample

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.ggu.firebase.R
import com.ggu.firebase.data.SampleRepository
import kotlinx.coroutines.Dispatchers

class SampleViewModel(private val repository: SampleRepository) : ViewModel() {

    fun getUsers(page: Int) = liveData(Dispatchers.IO) {
        Log.d("sampleTest", "getUsers()")
        emit(null)
        try {
            emit(repository.getUsers(page))
        } catch (e: Exception) {
            emit(repository.getUsers(page))
        }
    }

    fun getResources(page: Int) = liveData(Dispatchers.IO) {
        emit(null)
        try {
            emit(repository.getResources(page))
        } catch (e: Exception) {
            emit(repository.getResources(page))
        }
    }

    fun getRandomUser() = liveData(Dispatchers.IO) {
        emit(null)
        try {
            emit(repository.getRandomUser())
        } catch (e: Exception) {
            emit(repository.getRandomUser())
        }
    }

    fun getRandomResource() = liveData(Dispatchers.IO) {
        emit(null)
        try {
            emit(repository.getRandomResource())
        } catch (e: Exception) {
            emit(repository.getRandomResource())
        }
    }


    fun refresh(id:Int){
        when(id){
            R.id.users -> getUsers(1)
            R.id.resources -> getResources(1)
            R.id.random_user -> getRandomUser()
            R.id.random_resource -> getRandomResource()
        }
    }
}