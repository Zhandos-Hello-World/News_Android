package com.zhandos.news.feature_news.domain.use_cases

import com.zhandos.news.feature_news.domain.model.News
import com.zhandos.news.feature_news.domain.repository.NewsNetworkRepository

class GetNewsRemoteUseCase(private val repository: NewsNetworkRepository) {

    suspend operator fun invoke(): News {
        return repository.getAll()
    }
}