package com.newsdoubletwobyte.newsapp.di

import com.newsdoubletwobyte.newsapp.domain.NewsFetchByIdUseCase
import com.newsdoubletwobyte.newsapp.domain.NewsFetchUseCase
import dagger.Binds
import dagger.Module

@Module
interface DomainModule {

    @Binds
    fun bindNewsFetchByIdUseCase(impl: NewsFetchByIdUseCase.Base): NewsFetchByIdUseCase

    @Binds
    fun bindNewsFetchUseCase(impl: NewsFetchUseCase.Base): NewsFetchUseCase
}