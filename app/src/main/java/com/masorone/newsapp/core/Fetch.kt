package com.masorone.newsapp.core

interface Fetch<T> {

    suspend fun fetch(): T
}