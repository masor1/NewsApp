package com.newsdoubletwobyte.newsapp.domain.usecase

import com.newsdoubletwobyte.newsapp.core.Fetch
import com.newsdoubletwobyte.newsapp.domain.pojo.News
import com.newsdoubletwobyte.newsapp.domain.repository.NewsRepository

interface FetchNews : Fetch<List<News>> {

    class Base(
        private val repository: NewsRepository
    ) : FetchNews {

        override suspend fun fetch(page: Int) = repository.fetch()
    }
}