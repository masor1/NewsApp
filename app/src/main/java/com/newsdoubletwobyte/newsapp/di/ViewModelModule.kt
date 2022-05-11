package com.newsdoubletwobyte.newsapp.di

import androidx.lifecycle.ViewModel
import com.newsdoubletwobyte.newsapp.presentation.news_detail_screen.NewsDetailViewModel
import com.newsdoubletwobyte.newsapp.presentation.news_screen.NewsViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

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
}