package com.newsdoubletwobyte.newsapp.data.net

import com.newsdoubletwobyte.newsapp.core.Mapper
import com.newsdoubletwobyte.newsapp.data.cache.NewsDb
import com.newsdoubletwobyte.newsapp.domain.model.NewsDomain

data class NewsCloud(
    private val author: String?,
    private val title: String,
    private val description: String,
    private val url: String,
    private val urlToImage: String,
    private val publishedAt: String,
    private val id: Int = 0
) : Mapper<NewsDb> {

    override fun map() = NewsDb(
        id,
        author,
        title,
        description,
        urlToImage,
        publishedAt
    )
}