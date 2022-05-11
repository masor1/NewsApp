package com.newsdoubletwobyte.newsapp.data.cache

import com.newsdoubletwobyte.newsapp.core.CacheDataSource

interface NewsCacheDataSource : CacheDataSource {

    class Base(
        private val newsDao: NewsDao
    ) : NewsCacheDataSource {

        override suspend fun save(data: List<NewsCache>) = newsDao.save(data)

        override suspend fun fetch() = newsDao.fetch()

        override suspend fun fetch(id: Int) = newsDao.fetchById(id)
    }
}