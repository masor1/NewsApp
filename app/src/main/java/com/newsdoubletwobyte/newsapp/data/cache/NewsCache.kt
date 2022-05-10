package com.newsdoubletwobyte.newsapp.data.cache

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName
import com.newsdoubletwobyte.newsapp.core.Mapper
import com.newsdoubletwobyte.newsapp.domain.NewsDomain

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