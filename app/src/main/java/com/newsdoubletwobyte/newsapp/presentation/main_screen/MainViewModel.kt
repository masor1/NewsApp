package com.newsdoubletwobyte.newsapp.presentation.main_screen

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.newsdoubletwobyte.newsapp.core.Fetch
import com.newsdoubletwobyte.newsapp.domain.pojo.News
import com.newsdoubletwobyte.newsapp.domain.usecase.FetchNews
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.launch

class MainViewModel(
    private val newsUseCase: FetchNews,
    private val dispatcher: CoroutineDispatcher
) : ViewModel(), Fetch<Unit> {

    private val _news = MutableLiveData<List<News>>()
    val news: LiveData<List<News>> = _news

    private var count = 1

    init {
        viewModelScope.launch(dispatcher) {
            fetch()
        }
    }

    override suspend fun fetch(page: Int) {
        viewModelScope.launch(dispatcher) {
            val news = newsUseCase.fetch(page)
            _news.postValue(news)
        }
    }
}