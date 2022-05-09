package com.newsdoubletwobyte.newsapp.data.net.api.model

import com.google.gson.annotations.SerializedName

data class SourceDto(
    @SerializedName("id")
    private val id: String,
    @SerializedName("name")
    private val name: String
)
