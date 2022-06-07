package com.zhandos.news.feature_news.domain.use_cases

import com.zhandos.news.feature_news.domain.model.Article
import com.zhandos.news.feature_news.domain.repository.NewsLocalRepository

class AddNewLocalUseCase(private val newsLocalRepository: NewsLocalRepository) {
    suspend operator fun invoke(article: Article) {
        newsLocalRepository.insert(article)
    }
}