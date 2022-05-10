package com.newsdoubletwobyte.newsapp.presentation

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.newsdoubletwobyte.newsapp.R
import com.newsdoubletwobyte.newsapp.presentation.main_screen.NewsFragment

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        supportFragmentManager.beginTransaction()
            .replace(R.id.container, NewsFragment())
            .addToBackStack(null)
            .commit()
    }
}