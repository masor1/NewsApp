package com.newsdoubletwobyte.newsapp.data.cache

interface NewsCacheDataSource {

    fun save(listOfNewsCache: List<NewsCache>)

    fun fetch(): List<NewsCache>

    fun fetchById(newsId: Int): NewsCache

    class Base(
        private val newsDao: NewsDao
    ) : NewsCacheDataSource {

        override fun save(listOfNewsCache: List<NewsCache>) = newsDao.save(listOfNewsCache)

        override fun fetch() = newsDao.fetch()

        override fun fetchById(newsId: Int) = newsDao.fetchById(newsId)
    }
}