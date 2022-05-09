package com.newsdoubletwobyte.newsapp.domain.usecase

import com.newsdoubletwobyte.newsapp.core.Fetch
import com.newsdoubletwobyte.newsapp.domain.model.NewsDomain
import com.newsdoubletwobyte.newsapp.domain.repository.NewsRepository

interface FetchNews : Fetch<List<NewsDomain>> {

    class Base(
        private val repository: NewsRepository
    ) : FetchNews {

        override suspend fun fetch(page: String) = repository.fetch(page)
    }
}