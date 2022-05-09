package com.newsdoubletwobyte.newsapp.presentation.main_screen

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.newsdoubletwobyte.newsapp.data.net.api.NewsRetrofitBuilder
import com.newsdoubletwobyte.newsapp.data.net.CloudDataSource
import com.newsdoubletwobyte.newsapp.data.repository.BaseNewsRepository
import com.newsdoubletwobyte.newsapp.databinding.ActivityMainBinding
import com.newsdoubletwobyte.newsapp.domain.usecase.FetchNews
import com.newsdoubletwobyte.newsapp.presentation.main_screen.adapter.NewsAdapter

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    private lateinit var viewModel: MainViewModel
    private lateinit var newsAdapter: NewsAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(LayoutInflater.from(this))
        setContentView(binding.root)
        setupViewModel()
        setupRecyclerView()
        observeViewModel()
    }

    private fun setupViewModel() {
        val apiService = NewsRetrofitBuilder.newsApiServiceService
        val dataSource = CloudDataSource.Base(apiService)
        val repository = BaseNewsRepository(dataSource)
        viewModel = ViewModelProvider(
            this,
            MainViewModelFactory(
                FetchNews.Base(repository)
            )
        )[MainViewModel::class.java]
    }

    private fun setupRecyclerView() {
        newsAdapter = NewsAdapter()
        with(binding.newsRecyclerView) {
            adapter = newsAdapter
            recycledViewPool.setMaxRecycledViews(
                NewsAdapter.VIEW_TYPE,
                NewsAdapter.MAX_POOL_SIZE
            )
        }
    }

    private fun observeViewModel() {
        viewModel.news.observe(this) { listOfNews ->
            newsAdapter.submitList(listOfNews)
            binding.newsProgressBar.visibility = View.GONE
            binding.newsRecyclerView.visibility = View.VISIBLE
        }
    }
}