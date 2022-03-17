package com.newsdoubletwobyte.newsapp.presentation.main_screen

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.newsdoubletwobyte.newsapp.domain.usecase.FetchNews
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers

class MainViewModelFactory(
    private val newsUseCase: FetchNews,
    private val dispatcher: CoroutineDispatcher = Dispatchers.IO
) : ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(MainViewModel::class.java))
            return MainViewModel(
                newsUseCase,
                dispatcher
            ) as T
        throw IllegalArgumentException("Unknown ViewModel class: $modelClass")
    }
}