package com.example.marvelcharacters.characters.AllCharacters

import com.example.marvelcharacters.characters.SingleCharacter.Information
import com.google.gson.annotations.SerializedName

data class Result(
    @SerializedName("id")
    val id : Int,
    @SerializedName("name")
    val name : String,
    @SerializedName("description")
    val description : String,
    @SerializedName("resourceURI")
    val resourceURI : String,
    @SerializedName("thumbnail")
    val thumbnail : Thumbnail,

    @SerializedName("comics")
    val comics : Information,
    @SerializedName("series")
    val series : Information,
    @SerializedName("stories")
    val stories : Information,
    @SerializedName("events")
    val events : Information,
)
