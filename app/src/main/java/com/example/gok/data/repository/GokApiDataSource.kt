package com.example.gok.data.repository

import com.example.gok.data.RootProductsResult
import com.example.gok.data.model.RootResponse
import com.example.gok.data.service.ApiService
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class GokApiDataSource: GokRepository {

    override fun getProducts(productsResultCallBack: (result: RootProductsResult) -> Unit) {

        ApiService.service.getProducts().enqueue(object : Callback<RootResponse> {
            override fun onResponse(
                call: Call<RootResponse>,
                response: Response<RootResponse>
            ) {
                when {
                    response.isSuccessful -> {
                        response.body()?.let { rootResponse ->
                            productsResultCallBack(RootProductsResult.Success(rootResponse))
                        }
                    }
                }
            }

            override fun onFailure(call: Call<RootResponse>, t: Throwable) {
                productsResultCallBack(RootProductsResult.Error("Server Error"))
            }
        })
    }
}