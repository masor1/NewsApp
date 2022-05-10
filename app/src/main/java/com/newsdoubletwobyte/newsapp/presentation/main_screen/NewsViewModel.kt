package com.newsdoubletwobyte.newsapp.presentation.main_screen

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.newsdoubletwobyte.newsapp.core.Fetch
import com.newsdoubletwobyte.newsapp.domain.model.NewsDomain
import com.newsdoubletwobyte.newsapp.domain.usecase.FetchNews
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class NewsViewModel(
    private val newsUseCase: FetchNews,
    dispatcher: CoroutineDispatcher = Dispatchers.Main
) : ViewModel(), Fetch<Unit> {

    private val _news = MutableLiveData<List<NewsDomain>>()
    val news: LiveData<List<NewsDomain>> = _news

    init {
        viewModelScope.launch(dispatcher) {
            fetch("1")
        }
    }

    override suspend fun fetch(page: String) {
        _news.postValue(newsUseCase.fetch(page))
    }
}