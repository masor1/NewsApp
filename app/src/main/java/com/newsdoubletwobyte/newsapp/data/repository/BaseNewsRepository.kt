package com.newsdoubletwobyte.newsapp.data.repository

import com.newsdoubletwobyte.newsapp.data.cache.NewsCacheDataSource
import com.newsdoubletwobyte.newsapp.data.net.NewsCloudDataSource
import com.newsdoubletwobyte.newsapp.domain.model.NewsDomain
import com.newsdoubletwobyte.newsapp.domain.repository.NewsRepository

class BaseNewsRepository(
    private val cacheDataSource: NewsCacheDataSource,
    private val cloudDataSource: NewsCloudDataSource
) : NewsRepository {

    override suspend fun fetch(page: String): List<NewsDomain> {
        try {
            return if (cacheDataSource.fetch().isEmpty()) {
                val listOfNewsCloud = cloudDataSource.fetch(page)
                val listOfNewsDb = listOfNewsCloud.map { newsCloud ->
                    newsCloud.map()
                }
                cacheDataSource.save(listOfNewsDb)
                cacheDataSource.fetch().map { newsDb ->
                    newsDb.map()
                }
            } else {
                cacheDataSource.fetch().map { newsDb ->
                    newsDb.map()
                }
            }
        } catch (e: Exception) {
            return emptyList()
        }
    }
}