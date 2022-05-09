package com.newsdoubletwobyte.newsapp.data.net.api.model

import com.google.gson.annotations.SerializedName
import com.newsdoubletwobyte.newsapp.core.Mapper
import com.newsdoubletwobyte.newsapp.data.net.model.CloudNews

data class DataDto(
    @SerializedName("status")
    private val status: String,
    @SerializedName("totalResults")
    private val totalResults: Int,
    @SerializedName("articles")
    private val articles: ArrayList<ArticlesDto>
) : Mapper<List<CloudNews>> {

    override fun map(): List<CloudNews> {
        return articles.map {
            it.map()
        }
    }
}
