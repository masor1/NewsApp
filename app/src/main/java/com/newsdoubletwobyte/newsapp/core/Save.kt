package com.newsdoubletwobyte.newsapp.core

interface Save<T> {

    suspend fun save(data: T)
}