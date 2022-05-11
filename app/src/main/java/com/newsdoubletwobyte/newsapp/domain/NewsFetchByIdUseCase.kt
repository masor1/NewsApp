package com.newsdoubletwobyte.newsapp.domain

import com.newsdoubletwobyte.newsapp.core.FetchById
import javax.inject.Inject

interface NewsFetchByIdUseCase : FetchById<Int, NewsDomain> {

    class Base @Inject constructor(
        private val repository: NewsRepository
    ) : NewsFetchByIdUseCase {

        override suspend fun fetch(id: Int) = repository.fetch(id)
    }
}