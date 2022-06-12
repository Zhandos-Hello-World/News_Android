package com.zhandos.news.feature_news.domain.use_cases

import com.zhandos.news.feature_news.domain.model.News
import com.zhandos.news.feature_news.domain.repository.NewsRepository

class GetNewsRemoteUseCase(private val repository: NewsRepository) {

    suspend operator fun invoke(): News {
        return repository.getEverything()
    }

}