package com.masorone.newsapp.di

import com.masorone.newsapp.domain.NewsFetchByIdUseCase
import com.masorone.newsapp.domain.NewsFetchUseCase
import dagger.Binds
import dagger.Module

@Module
interface DomainModule {

    @Binds
    fun bindNewsFetchByIdUseCase(impl: NewsFetchByIdUseCase.Base): NewsFetchByIdUseCase

    @Binds
    fun bindNewsFetchUseCase(impl: NewsFetchUseCase.Base): NewsFetchUseCase
}