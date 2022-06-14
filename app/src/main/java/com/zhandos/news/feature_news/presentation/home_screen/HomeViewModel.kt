package com.zhandos.news.feature_news.presentation.home_screen

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.zhandos.news.feature_news.common.Resource
import com.zhandos.news.feature_news.domain.use_cases.NewsUseCases
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject


class HomeViewModel @Inject constructor(private val useCases: NewsUseCases) : ViewModel() {
    private var _status = MutableLiveData<NewsState>()
    var status: LiveData<NewsState> = _status

    init {
        getData()
    }

    private fun getData() {
        useCases.getEverythingUseCase().onEach { result ->
            when (result) {
                is Resource.Success -> {
                    _status.value = NewsState(isLoading = false, news = result.data)
                }
                is Resource.Loading -> {
                    _status.value = NewsState(isLoading = true)
                }
                is Resource.Error -> {
                    _status.value =
                        NewsState(error = result.message ?: "An unexpected error occurred")
                }
            }
        }.launchIn(viewModelScope)
    }

}