package com.newsdoubletwobyte.newsapp.core

interface Fetch<T> {

    suspend fun fetch(page: String): T
}