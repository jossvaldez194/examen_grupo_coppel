package com.example.marvelcharacters.characters.AllCharacters

import com.google.gson.annotations.SerializedName

data class Character(
    @SerializedName("results")
    val results: List<Result>,
)
