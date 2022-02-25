package com.example.marvelcharacters.characters.SuperHeroes

import com.google.gson.annotations.SerializedName

data class Biography(
    @SerializedName("fullName")
    val fullName: String,
    @SerializedName("alterEgos")
    val alterEgos: String,
    @SerializedName("placeOfBirth")
    val placeOfBirth: String,
    @SerializedName("firstAppearance")
    val firstAppearance: String,
    @SerializedName("publisher")
    val publisher: String,
    @SerializedName("alignment")
    val alignment: String,
)
