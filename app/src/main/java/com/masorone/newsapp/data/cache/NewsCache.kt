package com.masorone.newsapp.data.cache

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName
import com.masorone.newsapp.core.Mapper
import com.masorone.newsapp.domain.NewsDomain

@Entity(tableName = "news")
data class NewsCache(
    @SerializedName("id")
    @PrimaryKey(autoGenerate = true)
    val id: Int,
    @SerializedName("author")
    val author: String,
    @SerializedName("title")
    val title: String,
    @SerializedName("description")
    val description: String,
    @SerializedName("urlToImage")
    val urlToImage: String,
    @SerializedName("publishedAt")
    val publishedAt: String
) : Mapper<NewsDomain> {

    override fun map() = NewsDomain(
        id,
        author,
        title,
        description,
        urlToImage,
        publishedAt
    )
}