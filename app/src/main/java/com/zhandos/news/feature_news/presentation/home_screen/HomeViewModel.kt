package com.zhandos.news.feature_news.presentation.home_screen

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.zhandos.news.feature_news.domain.model.News
import com.zhandos.news.feature_news.domain.use_cases.NewsUseCases
import kotlinx.coroutines.launch
import javax.inject.Inject


class HomeViewModel @Inject constructor(private val useCases: NewsUseCases) : ViewModel() {
    var status = MutableLiveData<News>()

    init {
        getData()
    }

    private fun getData() {
        viewModelScope.launch {
            val news = useCases.getNewsRemoteUseCase()
            status.value = news
        }
    }

}