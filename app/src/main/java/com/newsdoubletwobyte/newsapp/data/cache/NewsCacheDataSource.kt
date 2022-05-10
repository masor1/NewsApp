package com.newsdoubletwobyte.newsapp.data.cache

import androidx.lifecycle.LiveData

interface NewsCacheDataSource {

    fun save(listOfNewsDb: List<NewsDb>)

    fun fetch(): List<NewsDb>

    fun fetchById(newsId: Int): NewsDb

    class Base(
        private val newsDao: NewsDao
    ) : NewsCacheDataSource {

        override fun save(listOfNewsDb: List<NewsDb>) = newsDao.save(listOfNewsDb)

        override fun fetch() = newsDao.fetch()

        override fun fetchById(newsId: Int) = newsDao.fetchById(newsId)
    }
}