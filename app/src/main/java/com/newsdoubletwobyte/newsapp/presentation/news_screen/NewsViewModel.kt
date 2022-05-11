package com.newsdoubletwobyte.newsapp.presentation.news_screen

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.newsdoubletwobyte.newsapp.domain.NewsDomain
import com.newsdoubletwobyte.newsapp.domain.NewsFetchUseCase
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.launch

class NewsViewModel(
    private val newsFetchUseCaseUseCase: NewsFetchUseCase,
    dispatcher: CoroutineDispatcher
) : ViewModel() {

    private val _news = MutableLiveData<List<NewsDomain>>()
    var news: LiveData<List<NewsDomain>> = _news

    init {
        viewModelScope.launch(dispatcher) {
            _news.value = newsFetchUseCaseUseCase.fetch()
        }
    }
}