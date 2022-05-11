package com.masorone.newsapp.presentation.news_screen

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.masorone.newsapp.domain.NewsDomain
import com.masorone.newsapp.domain.NewsFetchUseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

class NewsViewModel @Inject constructor(
    private val newsFetchUseCaseUseCase: NewsFetchUseCase
) : ViewModel() {

    private val _news = MutableLiveData<List<NewsDomain>>()
    var news: LiveData<List<NewsDomain>> = _news

    init {
        viewModelScope.launch(Dispatchers.Main) {
            _news.value = newsFetchUseCaseUseCase.fetch()
        }
    }
}