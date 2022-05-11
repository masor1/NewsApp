package com.newsdoubletwobyte.newsapp.data.net

import com.newsdoubletwobyte.newsapp.core.CloudDataSource
import com.newsdoubletwobyte.newsapp.data.net.api.NewsApiService
import javax.inject.Inject

interface NewsCloudDataSource : CloudDataSource {

    class Base @Inject constructor(
        private val newsApiService: NewsApiService
    ) : NewsCloudDataSource {

        override suspend fun fetch(page: String) = newsApiService.fetch(page).map()
    }
}