package com.example.tzrikmstrs.data.network

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitBuilder {
    private const val BASE_URL = "http://cars.cprogroup.ru/api/rubetek/"
    private fun getRetrofit():Retrofit{
        return Retrofit.Builder().baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory
                .create())
            .build()}
    val apiService: ApiService = getRetrofit().create(ApiService::class.java)
}