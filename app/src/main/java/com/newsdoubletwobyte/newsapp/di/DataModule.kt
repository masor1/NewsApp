package com.newsdoubletwobyte.newsapp.di

import android.app.Application
import com.newsdoubletwobyte.newsapp.data.BaseNewsRepository
import com.newsdoubletwobyte.newsapp.data.cache.NewsCacheDataSource
import com.newsdoubletwobyte.newsapp.data.cache.NewsDao
import com.newsdoubletwobyte.newsapp.data.cache.NewsDatabase
import com.newsdoubletwobyte.newsapp.data.net.NewsCloudDataSource
import com.newsdoubletwobyte.newsapp.data.net.api.NewsApiService
import com.newsdoubletwobyte.newsapp.data.net.api.NewsRetrofitBuilder
import com.newsdoubletwobyte.newsapp.domain.NewsRepository
import dagger.Binds
import dagger.Module
import dagger.Provides

@Module
interface DataModule {

    @Binds
    @ApplicationScope
    fun bindNewsRepository(impl: BaseNewsRepository): NewsRepository

    @Binds
    @ApplicationScope
    fun bindNewsCacheDataSource(impl: NewsCacheDataSource.Base): NewsCacheDataSource

    @Binds
    @ApplicationScope
    fun bindNewsCloudDataSource(impl: NewsCloudDataSource.Base): NewsCloudDataSource

    companion object {

        @Provides
        @ApplicationScope
        fun provideNewsDao(application: Application): NewsDao {
            return NewsDatabase.getInstance(application).newsDao()
        }

        @Provides
        @ApplicationScope
        fun provideNewsApiService(): NewsApiService {
            return NewsRetrofitBuilder.newsApiServiceService
        }
    }
}