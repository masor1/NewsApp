package com.newsdoubletwobyte.newsapp.presentation.news_screen.adapter

import androidx.recyclerview.widget.DiffUtil
import com.newsdoubletwobyte.newsapp.domain.NewsDomain

class NewsItemDiffCallback : DiffUtil.ItemCallback<NewsDomain>() {

    override fun areItemsTheSame(oldItem: NewsDomain, newItem: NewsDomain) =
        oldItem.areItemsTheSame(newItem)

    override fun areContentsTheSame(oldItem: NewsDomain, newItem: NewsDomain) =
        oldItem.areContentsTheSame(newItem)
}