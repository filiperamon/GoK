package com.example.gok.data.service

import com.example.gok.data.model.RootResponse
import retrofit2.Call
import retrofit2.http.GET

interface GokService {
    @GET("products")
    fun getProducts(): Call<RootResponse>
}