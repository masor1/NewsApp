package com.masorone.newsapp.di

import android.app.Application
import com.masorone.newsapp.presentation.news_detail_screen.NewsDetailFragment
import com.masorone.newsapp.presentation.news_screen.NewsFragment
import dagger.BindsInstance
import dagger.Component

@ApplicationScope
@Component(
    modules = [
        DataModule::class,
        DomainModule::class,
        ViewModelModule::class
    ]
)
interface AppComponent {

    fun inject(fragment: NewsFragment)

    fun inject(fragment: NewsDetailFragment)

    @Component.Factory
    interface Factory {

        fun create(
            @BindsInstance application: Application
        ): AppComponent
    }
}