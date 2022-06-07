package com.zhandos.news.feature_news.domain.use_cases

import androidx.lifecycle.LiveData
import com.zhandos.news.feature_news.domain.model.Article
import com.zhandos.news.feature_news.domain.repository.NewsLocalRepository

class GetNewsLocalUseCase(private val newsLocalRepository: NewsLocalRepository) {
    operator fun invoke(article: Article): LiveData<List<Article>> {
        return newsLocalRepository.getAll()
    }
}