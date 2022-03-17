package com.newsdoubletwobyte.newsapp.data.api.pojo

import com.google.gson.annotations.SerializedName

data class Source(
    @SerializedName("id")
    private val id: String,
    @SerializedName("name")
    private val name: String
)
