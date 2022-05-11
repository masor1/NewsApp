package com.masorone.newsapp.core

interface Save<T> {

    suspend fun save(data: T)
}