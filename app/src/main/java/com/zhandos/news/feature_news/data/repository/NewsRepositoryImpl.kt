package com.zhandos.news.feature_news.data.repository

import com.zhandos.news.feature_news.data.data_source.network.NewsApiHolder
import com.zhandos.news.feature_news.data.data_source.network.common.Category
import com.zhandos.news.feature_news.data.data_source.network.common.Sort
import com.zhandos.news.feature_news.data.data_source.network.dto.NewsSourceDto
import com.zhandos.news.feature_news.data.data_source.network.dto.toNews
import com.zhandos.news.feature_news.data.data_source.network.dto.toNewsSource
import com.zhandos.news.feature_news.data.data_source.network.dto.toSource
import com.zhandos.news.feature_news.domain.model.NewsArticle
import com.zhandos.news.feature_news.domain.model.NewsSource
import com.zhandos.news.feature_news.domain.repository.NewsRepository

class NewsRepositoryImpl(private val newsApiHolder: NewsApiHolder) : NewsRepository {

    override suspend fun getEverything(sortBy: Sort): NewsArticle {
        return newsApiHolder.getEverything().toNews()
    }

    override suspend fun getTopHeadlines(country: String, category: Category): NewsArticle {
        return newsApiHolder.getTopHeadlines(country, category).toNews()
    }

    override suspend fun getSources(county: String, category: Category): NewsSource {
        return newsApiHolder.getSources(county, category).toNewsSource()
    }


}