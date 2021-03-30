package com.example.gok.data.model

import com.google.gson.annotations.SerializedName

data class CashResponse(
    @SerializedName("title") val title: String,
    @SerializedName("bannerURL") val bannerUrl: String,
    @SerializedName("description") val description: String
)
