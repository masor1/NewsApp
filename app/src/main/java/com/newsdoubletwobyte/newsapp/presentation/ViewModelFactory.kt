package com.newsdoubletwobyte.newsapp.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.newsdoubletwobyte.newsapp.domain.NewsFetchUseCase
import com.newsdoubletwobyte.newsapp.presentation.main_screen.NewsViewModel
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers

class ViewModelFactory(
    private val newsFetchUseCaseUseCase: NewsFetchUseCase,
    private val dispatcher: CoroutineDispatcher = Dispatchers.IO
) : ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(NewsViewModel::class.java))
            return NewsViewModel(
                newsFetchUseCaseUseCase,
                dispatcher
            ) as T
        throw IllegalArgumentException("Unknown ViewModel class: $modelClass")
    }
}