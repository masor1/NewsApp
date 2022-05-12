package com.masorone.newsapp.di

import androidx.lifecycle.ViewModel
import com.masorone.newsapp.presentation.news_detail_screen.NewsDetailViewModel
import com.masorone.newsapp.presentation.news_screen.NewsViewModel
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.multibindings.IntoMap
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers

@Module
interface ViewModelModule {

    @IntoMap
    @ViewModelKey(NewsViewModel::class)
    @Binds
    fun bindNewsViewModel(impl: NewsViewModel): ViewModel

    @IntoMap
    @ViewModelKey(NewsDetailViewModel::class)
    @Binds
    fun bindNewsDetailViewModel(impl: NewsDetailViewModel): ViewModel

    companion object {

        @Provides
        @MainDispatcher
        fun provideMainDispatcher(): CoroutineDispatcher = Dispatchers.Main
    }
}