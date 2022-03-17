package com.newsdoubletwobyte.newsapp.data.api

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object NewsRetrofitBuilder {

    private const val BASE_URL = "https://newsapi.org/"

    private fun getRetrofit(): Retrofit {
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    val newsApiServiceService: NewsApiService = getRetrofit().create(NewsApiService::class.java)
}