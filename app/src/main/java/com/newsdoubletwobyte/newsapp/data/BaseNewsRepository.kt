package com.newsdoubletwobyte.newsapp.data

import android.util.Log
import com.newsdoubletwobyte.newsapp.data.cache.NewsCacheDataSource
import com.newsdoubletwobyte.newsapp.data.net.NewsCloudDataSource
import com.newsdoubletwobyte.newsapp.domain.NewsDomain
import com.newsdoubletwobyte.newsapp.domain.NewsRepository
import javax.inject.Inject

class BaseNewsRepository @Inject constructor(
    private val cacheDataSource: NewsCacheDataSource,
    private val cloudDataSource: NewsCloudDataSource
) : NewsRepository {

    override suspend fun fetch(): List<NewsDomain> {
        try {
            return if (cacheDataSource.fetch().isEmpty()) {
                val listOfNewsCloud = cloudDataSource.fetch(FIRST_PAGE)
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
            Log.d(javaClass.simpleName, "Exception: ${e.message}")
            return emptyList()
        }
    }

    override suspend fun fetch(id: Int) = cacheDataSource.fetch(id).map()

    companion object {

        private const val FIRST_PAGE = "1"
    }
}