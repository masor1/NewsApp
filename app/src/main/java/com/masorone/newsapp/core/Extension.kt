package com.masorone.newsapp.core

import androidx.appcompat.widget.AppCompatImageView
import com.bumptech.glide.Glide

object Extension {

    fun AppCompatImageView.loadWithGlide(url: String) {
        Glide.with(this).load(url)
            .error(android.R.drawable.ic_dialog_alert)
            .into(this)
    }
}