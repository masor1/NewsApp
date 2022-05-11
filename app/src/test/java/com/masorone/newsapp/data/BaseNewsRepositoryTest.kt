package com.masorone.newsapp.data

import com.masorone.newsapp.data.cache.NewsCache
import com.masorone.newsapp.data.cache.NewsCacheDataSource
import com.masorone.newsapp.data.net.NewsCloud
import com.masorone.newsapp.data.net.NewsCloudDataSource
import com.masorone.newsapp.domain.NewsDomain
import kotlinx.coroutines.runBlocking
import org.junit.Assert.assertEquals
import org.junit.Test

class BaseNewsRepositoryTest {

    @Test
    fun test() = runBlocking {

        class TestNewsCacheDataSource : NewsCacheDataSource {

            val list = mutableListOf<NewsCache>()

            override suspend fun save(data: List<NewsCache>) {
                list.addAll(data)
            }

            override suspend fun fetch(): List<NewsCache> {
                return list
            }

            override suspend fun fetch(id: Int): NewsCache {
                return list.find { it.id == id } ?: throw Exception()
            }
        }

        class TestNewsCloudDataSource : NewsCloudDataSource {

            override suspend fun fetch(page: String): List<NewsCloud> {
                return listOf(
                    NewsCloud(
                        "author1",
                        "title1",
                        "description1",
                        "url1",
                        "urlToImage1",
                        "1",
                        1
                    ),
                    NewsCloud(
                        "author2",
                        "title2",
                        "description2",
                        "url2",
                        "urlToImage2",
                        "2",
                        2
                    )
                )
            }
        }

        val testCacheDataSource = TestNewsCacheDataSource()
        val testCloudDataSource = TestNewsCloudDataSource()

        val repository = BaseNewsRepository(
            testCacheDataSource,
            testCloudDataSource
        )

        assertEquals(testCacheDataSource.fetch(), emptyList<NewsCache>())

        repository.fetch()

        assertEquals(
            testCacheDataSource.fetch(), listOf(
                NewsCache(
                    1,
                    "author1",
                    "title1",
                    "description1",
                    "urlToImage1",
                    "1"
                ),
                NewsCache(
                    2,
                    "author2",
                    "title2",
                    "description2",
                    "urlToImage2",
                    "2"
                )
            )
        )

        val actual = repository.fetch(2)
        val expected = NewsDomain(
            2,
            "author2",
            "title2",
            "description2",
            "urlToImage2",
            "2"
        )

        assertEquals(expected, actual)
    }
}