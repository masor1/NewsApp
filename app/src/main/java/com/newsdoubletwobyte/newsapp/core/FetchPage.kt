package com.newsdoubletwobyte.newsapp.core

interface FetchPage<T, P> {

    suspend fun fetch(page: T): P
}