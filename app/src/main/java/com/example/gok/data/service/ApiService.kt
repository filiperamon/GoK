package com.example.gok.data.service

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object ApiService {
    private fun initRetrofit(): Retrofit =
        Retrofit.Builder()
            .baseUrl("https://7hgi9vtkdc.execute-api.sa-east-1.amazonaws.com/sandbox/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

    val service: GokService = initRetrofit().create(GokService::class.java)
}