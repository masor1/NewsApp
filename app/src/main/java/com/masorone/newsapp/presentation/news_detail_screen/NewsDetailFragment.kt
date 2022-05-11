package com.masorone.newsapp.presentation.news_detail_screen

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.masorone.newsapp.App
import com.masorone.newsapp.databinding.FragmentNewsDetailBinding
import com.masorone.newsapp.presentation.ViewModelFactory
import javax.inject.Inject

class NewsDetailFragment : Fragment() {

    @Inject
    lateinit var viewModelFactory: ViewModelFactory

    private lateinit var viewModel: NewsDetailViewModel

    private var _binding: FragmentNewsDetailBinding? = null
    private val binding get() = _binding!!

    private val appComponent by lazy {
        (requireActivity().application as App).appComponent
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentNewsDetailBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        appComponent.inject(this)
        super.onViewCreated(view, savedInstanceState)

        val id = arguments?.getInt("id") ?: 0

        setupViewModel()
        viewModel.fetch(id)
        viewModel.news.observe(viewLifecycleOwner) { news ->
            news.bindNewsDetailItem(binding)
        }
    }

    private fun setupViewModel() {
        viewModel = ViewModelProvider(
            this,
            viewModelFactory
        )[NewsDetailViewModel::class.java]
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}