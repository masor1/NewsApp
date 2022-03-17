package com.newsdoubletwobyte.newsapp.data.api.pojo

import com.google.gson.annotations.SerializedName
import com.newsdoubletwobyte.newsapp.core.Mapper
import com.newsdoubletwobyte.newsapp.data.net.pojo.CloudNews

data class Articles(
    @SerializedName("source")
    private val source: Source,
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
    private val publishedAt: String,
    @SerializedName("content")
    private val content: String
) : Mapper<CloudNews> {

    override fun map() = CloudNews(
        author,
        title,
        description,
        url,
        urlToImage,
        publishedAt,
        content
    )
}
