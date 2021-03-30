package com.example.gok.data

import com.example.gok.data.model.RootResponse

sealed class RootProductsResult {
    class Success(val rootResult: RootResponse) : RootProductsResult()
    class Error(val error:String): RootProductsResult()
}