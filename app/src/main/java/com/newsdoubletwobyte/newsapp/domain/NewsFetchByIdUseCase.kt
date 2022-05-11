package com.newsdoubletwobyte.newsapp.domain

import com.newsdoubletwobyte.newsapp.core.FetchById

class NewsFetchByIdUseCase(
    private val repository: NewsRepository
) : FetchById<Int, NewsDomain> {

    override suspend fun fetch(id: Int) = repository.fetch(id)
}