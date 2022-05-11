package com.masorone.newsapp

import android.app.Application
import com.masorone.newsapp.di.DaggerAppComponent

class App : Application() {

    val appComponent by lazy {
        DaggerAppComponent.factory()
            .create(this)
    }
}