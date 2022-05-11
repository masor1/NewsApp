package com.newsdoubletwobyte.newsapp.presentation.news_detail_screen

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.newsdoubletwobyte.newsapp.data.BaseNewsRepository
import com.newsdoubletwobyte.newsapp.data.cache.NewsCacheDataSource
import com.newsdoubletwobyte.newsapp.data.cache.NewsDatabase
import com.newsdoubletwobyte.newsapp.data.net.NewsCloudDataSource
import com.newsdoubletwobyte.newsapp.data.net.api.NewsRetrofitBuilder
import com.newsdoubletwobyte.newsapp.databinding.FragmentNewsDetailBinding
import com.newsdoubletwobyte.newsapp.domain.NewsFetchByIdUseCase
import com.newsdoubletwobyte.newsapp.domain.NewsFetchUseCase
import com.newsdoubletwobyte.newsapp.presentation.ViewModelFactory

class NewsDetailFragment : Fragment() {

    private lateinit var viewModel: NewsDetailViewModel

    private var _binding: FragmentNewsDetailBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentNewsDetailBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val id = arguments?.getInt("id") ?: 0

        setupViewModel()
        viewModel.fetch(id)
        viewModel.news.observe(viewLifecycleOwner) { news ->
            news.bindNewsDetailItem(binding)
        }
    }

    private fun setupViewModel() {
        val apiService = NewsRetrofitBuilder.newsApiServiceService
        val cloudDataSource = NewsCloudDataSource.Base(apiService)
        val cacheDataSource = NewsCacheDataSource.Base(
            NewsDatabase.getInstance(requireActivity().application).newsDao()
        )
        val repository = BaseNewsRepository(cacheDataSource, cloudDataSource)
        viewModel = ViewModelProvider(
            this,
            ViewModelFactory(
                NewsFetchUseCase.Base(repository),
                NewsFetchByIdUseCase(repository)
            )
        )[NewsDetailViewModel::class.java]
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}