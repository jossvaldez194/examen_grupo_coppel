package com.example.marvelcharacters.models

import com.google.gson.annotations.SerializedName

data class CharacterId(
    @SerializedName("characterId")
    val characterId : Int
)
