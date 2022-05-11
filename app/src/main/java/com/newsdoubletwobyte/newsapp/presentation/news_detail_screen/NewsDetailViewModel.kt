package com.newsdoubletwobyte.newsapp.presentation.news_detail_screen

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.newsdoubletwobyte.newsapp.domain.NewsDomain
import com.newsdoubletwobyte.newsapp.domain.NewsFetchByIdUseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

class NewsDetailViewModel @Inject constructor(
    private val newsFetchByIdUseCase: NewsFetchByIdUseCase
) : ViewModel() {

    private val _news = MutableLiveData<NewsDomain>()
    var news: LiveData<NewsDomain> = _news

    fun fetch(id: Int) {
        viewModelScope.launch(Dispatchers.Main) {
            _news.value = newsFetchByIdUseCase.fetch(id)
        }
    }
}