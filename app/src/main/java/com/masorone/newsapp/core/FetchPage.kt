package com.masorone.newsapp.core

interface FetchPage<T, P> {

    suspend fun fetch(page: T): P
}