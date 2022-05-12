package com.masorone.newsapp.data.net.api

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class NewsRetrofitBuilder {

    private fun getRetrofit(): Retrofit {
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    val newsApiServiceService: NewsApiService = getRetrofit().create(NewsApiService::class.java)

    companion object {

        private const val BASE_URL = "https://newsapi.org/"
    }
}