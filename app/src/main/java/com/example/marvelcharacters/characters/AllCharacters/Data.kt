package com.example.marvelcharacters.characters.AllCharacters

import com.google.gson.annotations.SerializedName

data class Data(
    @SerializedName("data")
    val data: Character,
)
