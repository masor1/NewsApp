package com.masorone.newsapp.presentation.news_screen.adapter

import androidx.recyclerview.widget.DiffUtil
import com.masorone.newsapp.domain.NewsDomain

class NewsItemDiffCallback : DiffUtil.ItemCallback<NewsDomain>() {

    override fun areItemsTheSame(oldItem: NewsDomain, newItem: NewsDomain) =
        oldItem.areItemsTheSame(newItem)

    override fun areContentsTheSame(oldItem: NewsDomain, newItem: NewsDomain) =
        oldItem.areContentsTheSame(newItem)
}