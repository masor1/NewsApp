package com.masorone.newsapp.data.net.api.model

import com.google.gson.annotations.SerializedName
import com.masorone.newsapp.core.Mapper
import com.masorone.newsapp.data.net.NewsCloud

data class ArticlesDto(
    @SerializedName("source")
    private val sourceDto: SourceDto,
    @SerializedName("author")
    private val author: String,
    @SerializedName("title")
    private val title: String,
    @SerializedName("description")
    private val description: String,
    @SerializedName("url")
    private val url: String,
    @SerializedName("urlToImage")
    private val urlToImage: String,
    @SerializedName("publishedAt")
    private val publishedAt: String
) : Mapper<NewsCloud> {

    override fun map() = NewsCloud(
        author,
        title,
        description,
        url,
        urlToImage,
        publishedAt
    )
}
