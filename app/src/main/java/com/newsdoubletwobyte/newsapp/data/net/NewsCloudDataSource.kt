package com.newsdoubletwobyte.newsapp.data.net

import com.newsdoubletwobyte.newsapp.data.net.api.NewsApiService

interface NewsCloudDataSource {

    suspend fun fetch(page: String): List<NewsCloud>

    class Base(
        private val newsApiService: NewsApiService
    ) : NewsCloudDataSource {

        override suspend fun fetch(page: String) = newsApiService.fetch(page).map()
    }
}