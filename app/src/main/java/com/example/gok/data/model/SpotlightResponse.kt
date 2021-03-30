package com.example.gok.data.model

import com.google.gson.annotations.SerializedName

data class SpotlightResponse(
    @SerializedName("name") val name: String,
    @SerializedName("bannerURL") val bannerUrl: String,
    @SerializedName("description") val description: String
)
