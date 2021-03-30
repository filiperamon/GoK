package com.example.gok.data.model

import com.google.gson.annotations.SerializedName

data class RootResponse(
    @SerializedName("spotlight") val spotlight: List<SpotlightResponse>,
    @SerializedName("products") val products: List<ProductResponse>,
    @SerializedName("cash") val cash: CashResponse
)
