package com.example.gok.data.model

import com.google.gson.annotations.SerializedName

data class ProductResponse(
    @SerializedName("name") val name: String,
    @SerializedName("imageURL") val imageUrl: String,
    @SerializedName("description") val description: String
)
