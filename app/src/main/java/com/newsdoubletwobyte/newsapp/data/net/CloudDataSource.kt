package com.newsdoubletwobyte.newsapp.data.net

import com.newsdoubletwobyte.newsapp.core.Fetch
import com.newsdoubletwobyte.newsapp.data.api.NewsApiService
import com.newsdoubletwobyte.newsapp.data.net.pojo.CloudNews

interface CloudDataSource : Fetch<List<CloudNews>> {

    class Base(
        private val newsApiService: NewsApiService
    ) : CloudDataSource {
        override suspend fun fetch(page: Int) = newsApiService.fetch().map()
    }
}