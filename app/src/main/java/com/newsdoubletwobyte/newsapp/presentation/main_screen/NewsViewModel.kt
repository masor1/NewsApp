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
) : ViewModel() {

    private val _news = MutableLiveData<List<NewsDomain>>()
    var news: LiveData<List<NewsDomain>> = _news

    init {
        viewModelScope.launch(dispatcher) {
            fetch()
        }
    }

    private suspend fun fetch() {
        _news.postValue(newsUseCase.fetch("1"))
    }
}