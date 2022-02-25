package com.example.marvelcharacters.characters.SuperHeroes

import com.google.gson.annotations.SerializedName

data class Images(
    @SerializedName("xs")
    val xs: String,
    @SerializedName("sm")
    val sm: String,
    @SerializedName("md")
    val md: String,
    @SerializedName("lg")
    val lg: String,
)
