package com.example.marvelcharacters.repository.remote

import com.google.gson.GsonBuilder
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object ApiClient {

    //var BASE_URL: String = "https://gateway.marvel.com/"
    var BASE_URL: String = "https://akabab.github.io/superhero-api/api/"

    fun apiClient(): Retrofit {

        val gson = GsonBuilder()
            .setLenient()
            .create()

        val retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create(gson))
            .build()

        return retrofit

    }


}