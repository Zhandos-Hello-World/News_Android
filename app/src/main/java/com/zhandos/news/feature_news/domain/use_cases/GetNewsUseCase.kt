package com.zhandos.news.feature_news.domain.use_cases

import androidx.lifecycle.MutableLiveData
import com.zhandos.news.feature_news.domain.model.News
import com.zhandos.news.feature_news.domain.repository.NewsNetworkRepository

class GetNewsUseCase(private val repository: NewsNetworkRepository) {

    suspend operator fun invoke(): News {
        return repository.getAll()
    }
}