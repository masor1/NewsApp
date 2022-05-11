package com.newsdoubletwobyte.newsapp.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.newsdoubletwobyte.newsapp.domain.NewsFetchByIdUseCase
import com.newsdoubletwobyte.newsapp.domain.NewsFetchUseCase
import com.newsdoubletwobyte.newsapp.presentation.news_detail_screen.NewsDetailViewModel
import com.newsdoubletwobyte.newsapp.presentation.news_screen.NewsViewModel
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers

class ViewModelFactory(
    private val newsFetchUseCaseUseCase: NewsFetchUseCase,
    private val newsFetchByIdUseCase: NewsFetchByIdUseCase,
    private val dispatcher: CoroutineDispatcher = Dispatchers.Main
) : ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return when (modelClass) {
            NewsViewModel::class.java -> NewsViewModel(
                newsFetchUseCaseUseCase,
                dispatcher
            ) as T
            NewsDetailViewModel::class.java -> NewsDetailViewModel(
                newsFetchByIdUseCase,
                dispatcher
            ) as T
            else -> throw IllegalArgumentException("Unknown ViewModel class: $modelClass")
        }
    }
}