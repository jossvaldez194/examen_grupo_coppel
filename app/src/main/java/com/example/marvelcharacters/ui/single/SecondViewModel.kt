package com.example.marvelcharacters.ui.single

import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.example.marvelcharacters.repository.remote.ApiClient
import com.example.marvelcharacters.repository.remote.ApiService
import com.example.marvelcharacters.repository.remote.Resource
import kotlinx.coroutines.Dispatchers

class SecondViewModel : ViewModel() {

    fun  getSingleUser(idCharacterId : Int = 0) = liveData(Dispatchers.IO){
        emit(Resource.loading(data = null))
        try {
            emit(
                Resource.success(
                    data = ApiClient.apiClient().create(
                        ApiService::class.java
                    ).getSingleCharacter(id = idCharacterId)
                )
            )
        } catch (exception: Exception) {
            emit(Resource.error(data = null, message = exception.message ?: "Ocurrio un errror"))
        }
    }
}