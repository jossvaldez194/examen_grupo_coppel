package com.example.marvelcharacters.characters.SuperHeroes

import com.google.gson.annotations.SerializedName

data class SuperHeroe(
    @SerializedName("id")
    val id: Int,
    @SerializedName("name")
    val name: String,
    @SerializedName("images")
    val images: Images,
    @SerializedName("powerstats")
    val powerstats: Powerstats,
    @SerializedName("appearance")
    val appearance: Appearance,
    @SerializedName("biography")
    val biography: Biography,
    @SerializedName("work")
    val work: Work,
    @SerializedName("connections")
    val connections: Connections,

)
