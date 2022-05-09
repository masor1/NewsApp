package com.newsdoubletwobyte.newsapp.data.net

import com.newsdoubletwobyte.newsapp.core.Fetch
import com.newsdoubletwobyte.newsapp.data.net.api.NewsApiService
import com.newsdoubletwobyte.newsapp.data.net.model.CloudNews

interface CloudDataSource : Fetch<List<CloudNews>> {

    class Base(
        private val newsApiService: NewsApiService
    ) : CloudDataSource {

        override suspend fun fetch(page: String) = newsApiService.fetch(page = page).map()
    }
}