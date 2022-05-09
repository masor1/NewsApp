package com.newsdoubletwobyte.newsapp.data.net.model

import com.newsdoubletwobyte.newsapp.core.Mapper
import com.newsdoubletwobyte.newsapp.domain.model.NewsDomain

data class CloudNews(
    private val author: String?,
    private val title: String,
    private val description: String,
    private val url: String,
    private val urlToImage: String,
    private val publishedAt: String,
    private val content: String
) : Mapper<NewsDomain> {

    override fun map() = NewsDomain(
        author,
        title,
        description,
        urlToImage,
        publishedAt
    )
}