package com.example.marvelcharacters.characters.SuperHeroes

import com.google.gson.annotations.SerializedName

data class Work(
    @SerializedName("occupation")
    val occupation: String,
    @SerializedName("base")
    val base: String,
)
