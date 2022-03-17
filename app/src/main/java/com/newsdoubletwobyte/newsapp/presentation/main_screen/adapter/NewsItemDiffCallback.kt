package com.newsdoubletwobyte.newsapp.presentation.main_screen.adapter

import androidx.recyclerview.widget.DiffUtil
import com.newsdoubletwobyte.newsapp.domain.pojo.News

class NewsItemDiffCallback : DiffUtil.ItemCallback<News>() {

    override fun areItemsTheSame(oldItem: News, newItem: News) =
        oldItem.areItemsTheSame(newItem)

    override fun areContentsTheSame(oldItem: News, newItem: News) =
        oldItem.areContentsTheSame(newItem)
}