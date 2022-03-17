package com.newsdoubletwobyte.newsapp.core

interface Fetch<T> {

    suspend fun fetch(page: Int = 1): T
}