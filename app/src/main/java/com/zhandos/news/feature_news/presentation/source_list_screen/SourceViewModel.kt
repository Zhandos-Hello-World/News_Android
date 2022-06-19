package com.zhandos.news.feature_news.presentation.source_list_screen

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.zhandos.news.feature_news.common.Resource
import com.zhandos.news.feature_news.domain.use_cases.NewsUseCases
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject


class SourceViewModel @Inject constructor(private val useCases: NewsUseCases) : ViewModel() {
    private var _status = MutableLiveData<SourceState>()
    val status: LiveData<SourceState> = _status

    init {
        getData()
    }

    private fun getData() {
        useCases.getSourcesUseCase().onEach { result ->
            when (result) {
                is Resource.Success -> {
                    _status.value = SourceState(isLoading = false, newsSource = result.data)
                    Log.d("NewsSource", "Success")
                }
                is Resource.Loading -> {
                    _status.value = SourceState(isLoading = true)
                    Log.d("NewsSource", "Loading")

                }
                is Resource.Error -> {
                    _status.value =
                        SourceState(error = result.message ?: "An unexpected error occurred")
                    Log.d("NewsSource", "Error")
                }
            }
        }.launchIn(viewModelScope)
    }
}