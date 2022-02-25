package com.example.marvelcharacters.repository.remote

import com.example.marvelcharacters.characters.AllCharacters.Data
import com.example.marvelcharacters.characters.SuperHeroes.SuperHeroe
import com.example.marvelcharacters.utils.Constants.HASH_MD5
import com.example.marvelcharacters.utils.Constants.MARVEL_API_KEY
import retrofit2.http.*

interface ApiService {

    /*@GET("v1/public/characters")
    suspend fun getCharacters(
        @Query("ts") st: Int = 1,
        @Query("apikey") apikey: String = MARVEL_API_KEY,
        @Query("hash") hash: String = HASH_MD5
    ): Data*/
    @GET("all.json")
    suspend fun getCharacters(): List<SuperHeroe>

    /*@GET("v1/public/characters/{characterId}")
    suspend fun getSingleCharacter(
        @Path("characterId") characterid: Int,
        @Query("ts") st: Int = 1,
        @Query("apikey") apikey: String = MARVEL_API_KEY,
        @Query("hash") hash: String = HASH_MD5,
    ): Data*/
    @GET("id/{id}.json")
    suspend fun getSingleCharacter(@Path("id") id: Int): SuperHeroe
}