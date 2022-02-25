package com.example.marvelcharacters.ui.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.example.marvelcharacters.models.CharacterId
import com.example.marvelcharacters.repository.remote.ApiClient
import com.example.marvelcharacters.repository.remote.ApiService
import com.example.marvelcharacters.repository.remote.Resource
import kotlinx.coroutines.Dispatchers

class MainViewModel : ViewModel() {

    fun getUsers() = liveData(Dispatchers.IO) {
        emit(Resource.loading(data = null))
        try {
            emit(
                Resource.success(
                    data = ApiClient.apiClient().create(
                        ApiService::class.java
                    ).getCharacters()
                )
            )
        } catch (exception: Exception) {
            emit(Resource.error(data = null, message = exception.message ?: "Ocurrio un errror"))
        }
    }
}