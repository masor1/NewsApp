package com.masorone.newsapp.data.cache

import com.masorone.newsapp.core.CacheDataSource
import javax.inject.Inject

interface NewsCacheDataSource : CacheDataSource {

    class Base @Inject constructor(
        private val newsDao: NewsDao
    ) : NewsCacheDataSource {

        override suspend fun save(data: List<NewsCache>) = newsDao.save(data)

        override suspend fun fetch() = newsDao.fetch()

        override suspend fun fetch(id: Int) = newsDao.fetchById(id)
    }
}