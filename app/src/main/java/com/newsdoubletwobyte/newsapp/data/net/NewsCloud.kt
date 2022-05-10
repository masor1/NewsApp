package com.newsdoubletwobyte.newsapp.data.net

import com.newsdoubletwobyte.newsapp.core.Mapper
import com.newsdoubletwobyte.newsapp.data.cache.NewsCache

data class NewsCloud(
    private val author: String,
    private val title: String,
    private val description: String,
    private val url: String,
    private val urlToImage: String,
    private val publishedAt: String,
    private val id: Int = 0
) : Mapper<NewsCache> {

    override fun map() = NewsCache(
        id,
        author,
        title,
        description,
        urlToImage,
        publishedAt
    )
}