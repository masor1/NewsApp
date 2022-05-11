package com.masorone.newsapp.domain

import com.masorone.newsapp.R
import com.masorone.newsapp.core.Extension.loadWithGlide
import com.masorone.newsapp.databinding.FragmentNewsDetailBinding
import com.masorone.newsapp.databinding.NewsItemBinding

data class NewsDomain(
    private val id: Int,
    private val author: String?,
    private val title: String,
    private val description: String,
    private val imageUrl: String,
    private val date: String
) {

    fun passId() = Pair(KEY_ID, id)

    fun areItemsTheSame(newItem: NewsDomain) = id == newItem.id

    fun areContentsTheSame(newItem: NewsDomain) = this == newItem

    fun bindNewsItem(binding: NewsItemBinding) = with(binding) {
        newsItemTitle.text = title
        newsItemImage.loadWithGlide(imageUrl)
        newsItemDate.text = date.replace('T', ' ').replace('Z', ' ')
        newsItemAuthor.text = root.resources.getString(R.string.author, author)
    }

    fun bindNewsDetailItem(binding: FragmentNewsDetailBinding) = with(binding) {
        newsItemTitle.text = title
        newsItemImage.loadWithGlide(imageUrl)
        newsItemDescription.text = description
        newsItemDate.text = date.replace('T', ' ').replace('Z', ' ')
        newsItemAuthor.text = root.resources.getString(R.string.author, author)
    }

    private companion object {

        const val KEY_ID = "id"
    }
}