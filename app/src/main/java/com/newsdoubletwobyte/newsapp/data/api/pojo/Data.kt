package com.newsdoubletwobyte.newsapp.data.api.pojo

import com.google.gson.annotations.SerializedName
import com.newsdoubletwobyte.newsapp.core.Mapper
import com.newsdoubletwobyte.newsapp.data.net.pojo.CloudNews

data class Data(
    @SerializedName("status")
    private val status: String,
    @SerializedName("totalResults")
    private val totalResults: Int,
    @SerializedName("articles")
    private val articles: ArrayList<Articles>
) : Mapper<List<CloudNews>> {

    override fun map(): List<CloudNews> {
        return articles.map {
            it.map()
        }
    }
}
