package com.newsdoubletwobyte.newsapp.presentation.main_screen

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.newsdoubletwobyte.newsapp.R

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