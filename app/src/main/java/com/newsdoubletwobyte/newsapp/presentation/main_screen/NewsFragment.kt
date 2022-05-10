package com.newsdoubletwobyte.newsapp.presentation.main_screen

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.newsdoubletwobyte.newsapp.data.net.CloudDataSource
import com.newsdoubletwobyte.newsapp.data.net.api.NewsRetrofitBuilder
import com.newsdoubletwobyte.newsapp.data.repository.BaseNewsRepository
import com.newsdoubletwobyte.newsapp.databinding.FragmentNewsBinding
import com.newsdoubletwobyte.newsapp.domain.usecase.FetchNews
import com.newsdoubletwobyte.newsapp.presentation.main_screen.adapter.NewsAdapter

class NewsFragment : Fragment() {

    private var _binding: FragmentNewsBinding? = null
    private val binding get() = _binding!!

    private lateinit var viewModel: MainViewModel
    private lateinit var newsAdapter: NewsAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentNewsBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
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
        viewModel.news.observe(viewLifecycleOwner) { listOfNews ->
            newsAdapter.submitList(listOfNews)
            binding.newsProgressBar.visibility = View.GONE
            binding.newsRecyclerView.visibility = View.VISIBLE
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}