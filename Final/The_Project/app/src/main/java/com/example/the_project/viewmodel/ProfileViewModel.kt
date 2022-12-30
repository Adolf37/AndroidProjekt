package com.example.the_project.viewmodel

import android.content.Context
import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import com.example.the_project.MyApplication
import com.example.the_project.model.User
import com.example.the_project.repository.TrackerRepository
import kotlinx.coroutines.launch

class ProfileViewModelFactory(private val context: Context, private val repository: TrackerRepository): ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return ProfileViewModel(context, repository) as T
    }
}

class ProfileViewModel (val context: Context, val repository: TrackerRepository): ViewModel() {

    var user = MutableLiveData<User>()

    fun getUserInformation(wantedUser: String = MyApplication.token) {
        viewModelScope.launch {
            try {
                val response = repository.getUser(MyApplication.token)
                if(response.isSuccessful) {
                    user.value = response.body()
                } else{
                    Log.i("xxx-uvm", response.message())
                }

            }catch(e: Exception){
                Log.d("xxx", e.toString())
            }
        }
    }
}