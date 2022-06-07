package com.zhandos.news.feature_news.data.repository

import com.zhandos.news.feature_news.data.data_source.network.NewsApiHolder
import com.zhandos.news.feature_news.domain.model.News
import com.zhandos.news.feature_news.domain.repository.NewsNetworkRepository

class NewsNetworkRepositoryImpl(private val newsApiHolder: NewsApiHolder) : NewsNetworkRepository {

    override suspend fun getAll(): News {
        return newsApiHolder.getAllNewsResponse()
    }
}