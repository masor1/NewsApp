package com.newsdoubletwobyte.newsapp.data.net.pojo

import com.newsdoubletwobyte.newsapp.core.Mapper
import com.newsdoubletwobyte.newsapp.domain.pojo.News

data class CloudNews(
    private val author: String?,
    private val title: String,
    private val description: String,
    private val url: String,
    private val urlToImage: String,
    private val publishedAt: String,
    private val content: String
) : Mapper<News> {

    override fun map() = News(
        author,
        title,
        description,
        urlToImage,
        publishedAt
    )
}