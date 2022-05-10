package com.newsdoubletwobyte.newsapp.data

data class NewsData(
    private val id: Int,
    private val author: String?,
    private val title: String,
    private val description: String,
    private val urlToImage: String,
    private val publishedAt: String
)
