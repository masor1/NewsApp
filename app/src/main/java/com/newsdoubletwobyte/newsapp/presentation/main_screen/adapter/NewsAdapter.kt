package com.newsdoubletwobyte.newsapp.presentation.main_screen.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.newsdoubletwobyte.newsapp.databinding.NewsItemBinding
import com.newsdoubletwobyte.newsapp.domain.pojo.News

class NewsAdapter : ListAdapter<News, NewsAdapter.NewsViewHolder>(
    NewsItemDiffCallback()
) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NewsViewHolder {
        val binding = NewsItemBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return NewsViewHolder(binding)
    }

    override fun onBindViewHolder(holder: NewsViewHolder, position: Int) {
        val newsItem = getItem(position)
        holder.bind(newsItem)
    }

    override fun getItemViewType(position: Int) = VIEW_TYPE

    inner class NewsViewHolder(private val binding: NewsItemBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(newsItem: News) {
            newsItem.setInView(binding)
        }
    }

    companion object {
        const val VIEW_TYPE = 0
        const val MAX_POOL_SIZE = 10
    }
}