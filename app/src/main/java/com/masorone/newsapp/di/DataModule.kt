package com.masorone.newsapp.di

import android.app.Application
import com.masorone.newsapp.data.BaseNewsRepository
import com.masorone.newsapp.data.cache.NewsCacheDataSource
import com.masorone.newsapp.data.cache.NewsDao
import com.masorone.newsapp.data.cache.NewsDatabase
import com.masorone.newsapp.data.net.NewsCloudDataSource
import com.masorone.newsapp.data.net.api.NewsApiService
import com.masorone.newsapp.data.net.api.NewsRetrofitBuilder
import com.masorone.newsapp.domain.NewsRepository
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