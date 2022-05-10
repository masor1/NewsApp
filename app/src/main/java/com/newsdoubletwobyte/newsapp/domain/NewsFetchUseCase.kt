package com.newsdoubletwobyte.newsapp.domain

import com.newsdoubletwobyte.newsapp.core.Fetch

interface NewsFetchUseCase : Fetch<List<NewsDomain>> {

    class Base(
        private val repository: NewsRepository
    ) : NewsFetchUseCase {

        override suspend fun fetch(page: String) = repository.fetch(page)
    }
}