package com.ggu.firebase.ui.sample

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.ggu.firebase.data.SampleRepository
import com.ggu.firebase.data.model.SampleData
import com.ggu.firebase.data.model.User
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class SampleViewModel(private val repository: SampleRepository) : ViewModel() {

    private val users: MutableLiveData<SampleData<User>> = MutableLiveData()

    suspend fun getUsers(page: Int) : LiveData<SampleData<User>> {
        if(users.value == null){
            val u = withContext(Dispatchers.IO) { repository.getUsers(1) }
            users.value = u
        }

        return users
    }
}