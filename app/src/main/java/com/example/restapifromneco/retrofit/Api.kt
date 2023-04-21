package com.example.restapifromneco.retrofit

import retrofit2.http.GET

interface Api {
    @GET("random")
    suspend fun getApi(): Product
}