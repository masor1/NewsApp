package com.masorone.newsapp.data.net

import com.masorone.newsapp.core.CloudDataSource
import com.masorone.newsapp.data.net.api.NewsApiService
import javax.inject.Inject

interface NewsCloudDataSource : CloudDataSource {

    class Base @Inject constructor(
        private val newsApiService: NewsApiService
    ) : NewsCloudDataSource {

        override suspend fun fetch(page: String) = newsApiService.fetch(page).map()
    }
}