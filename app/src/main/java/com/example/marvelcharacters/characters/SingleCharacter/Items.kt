package com.example.marvelcharacters.characters.SingleCharacter

import com.google.gson.annotations.SerializedName

data class Items(
    @SerializedName("resourceURI")
    val resourceURI : String,
    @SerializedName("name")
    val name : String,
)
