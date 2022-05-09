package com.newsdoubletwobyte.newsapp.data.repository

import com.newsdoubletwobyte.newsapp.data.net.CloudDataSource
import com.newsdoubletwobyte.newsapp.domain.repository.NewsRepository

class BaseNewsRepository(
    private val cloudDataSource: CloudDataSource
) : NewsRepository {

    override suspend fun fetch(page: String) = cloudDataSource.fetch(page = page).map { it.map() }
}