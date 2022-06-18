package com.zhandos.news.feature_news.domain.repository

import com.zhandos.news.feature_news.data.data_source.network.common.Category
import com.zhandos.news.feature_news.data.data_source.network.common.Sort
import com.zhandos.news.feature_news.data.data_source.network.dto.NewsSourceDto
import com.zhandos.news.feature_news.domain.model.NewsArticle
import com.zhandos.news.feature_news.domain.model.NewsSource

interface NewsRepository {

    suspend fun getEverything(sortBy: Sort = Sort.RELEVANCY): NewsArticle

    suspend fun getTopHeadlines(
        country: String = "us",
        category: Category = Category.SCIENCE
    ): NewsArticle

    suspend fun getSources(
        county: String = "us",
        category: Category = Category.GENERAL
    ): NewsSource

}