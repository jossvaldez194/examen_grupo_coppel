package com.example.marvelcharacters.characters.SuperHeroes

import com.google.gson.annotations.SerializedName

data class Appearance(

    @SerializedName("gender")
    val gender: String,
    @SerializedName("race")
    val race: String,
    @SerializedName("eyeColor")
    val eyeColor: String,
    @SerializedName("hairColor")
    val hairColor: String,
    @SerializedName("height")
    val height: List<String>,
)
