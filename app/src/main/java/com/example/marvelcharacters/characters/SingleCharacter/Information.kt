package com.example.marvelcharacters.characters.SingleCharacter

import com.google.gson.annotations.SerializedName

data class Information(
    @SerializedName("available")
    val available : Int,
    @SerializedName("collectionURI")
    val collectionURI : String,
    @SerializedName("returned")
    val returned : Int,
    @SerializedName("Items")
    val items : List<Items>

)
