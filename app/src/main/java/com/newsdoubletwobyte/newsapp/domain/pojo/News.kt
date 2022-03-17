package com.newsdoubletwobyte.newsapp.domain.pojo

import com.newsdoubletwobyte.newsapp.R
import com.newsdoubletwobyte.newsapp.core.Extension.loadWithGlide
import com.newsdoubletwobyte.newsapp.databinding.NewsItemBinding

data class News(
    private val author: String?,
    private val title: String,
    private val description: String,
    private val imageUrl: String,
    private val date: String
) {
    fun areItemsTheSame(newItem: News) = title == newItem.title

    fun areContentsTheSame(newItem: News) = this == newItem

    fun setInView(binding: NewsItemBinding) {
        with(binding) {
            newsItemTitle.text = title
            newsItemImage.loadWithGlide(imageUrl)
            newsItemDescription.text = description
            newsItemDate.text = date.replace('T', ' ').replace('Z', ' ')
            newsItemAuthor.text = root.resources.getString(R.string.author, author)
        }
    }
}