package com.newsdoubletwobyte.newsapp.core

interface FetchById<T, M> {

    suspend fun fetch(id: T): M
}