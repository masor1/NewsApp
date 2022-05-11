package com.masorone.newsapp.core

interface FetchById<T, M> {

    suspend fun fetch(id: T): M
}