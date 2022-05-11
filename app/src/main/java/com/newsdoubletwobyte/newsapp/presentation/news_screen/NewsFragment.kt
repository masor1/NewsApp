package com.newsdoubletwobyte.newsapp.presentation.news_screen

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.newsdoubletwobyte.newsapp.App
import com.newsdoubletwobyte.newsapp.R
import com.newsdoubletwobyte.newsapp.databinding.FragmentNewsBinding
import com.newsdoubletwobyte.newsapp.domain.NewsDomain
import com.newsdoubletwobyte.newsapp.presentation.ViewModelFactory
import com.newsdoubletwobyte.newsapp.presentation.news_screen.adapter.NewsAdapter
import javax.inject.Inject

class NewsFragment : Fragment() {

    @Inject
    lateinit var viewModelFactory: ViewModelFactory

    private lateinit var newsAdapter: NewsAdapter
    private lateinit var viewModel: NewsViewModel

    private var _binding: FragmentNewsBinding? = null
    private val binding get() = _binding!!

    private val appComponent by lazy {
        (requireActivity().application as App).appComponent
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentNewsBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        appComponent.inject(this)
        super.onViewCreated(view, savedInstanceState)
        setupViewModel()
        setupRecyclerView()
        observeViewModel()
    }

    private fun setupViewModel() {
        viewModel = ViewModelProvider(
            this,
            viewModelFactory
        )[NewsViewModel::class.java]
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
        newsAdapter.onNewsItemClickListener = object : NewsAdapter.OnNewsItemClickListener {

            override fun onClick(newsItem: NewsDomain) = findNavController().navigate(
                R.id.action_newsFragment_to_newsDetailFragment,
                Bundle().apply {
                    val passId = newsItem.passId()
                    putInt(passId.first, passId.second)
                }
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