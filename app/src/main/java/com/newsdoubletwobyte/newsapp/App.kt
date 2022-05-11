package com.newsdoubletwobyte.newsapp

import android.app.Application
import com.newsdoubletwobyte.newsapp.di.DaggerAppComponent

class App : Application() {

    val appComponent by lazy {
        DaggerAppComponent.factory()
            .create(this)
    }
}