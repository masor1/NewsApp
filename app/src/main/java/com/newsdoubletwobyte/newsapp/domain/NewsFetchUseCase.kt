package com.newsdoubletwobyte.newsapp.domain

import com.newsdoubletwobyte.newsapp.core.Fetch
import javax.inject.Inject

interface NewsFetchUseCase : Fetch<List<NewsDomain>> {

    class Base @Inject constructor(
        private val repository: NewsRepository
    ) : NewsFetchUseCase {

        override suspend fun fetch() = repository.fetch()
    }
}