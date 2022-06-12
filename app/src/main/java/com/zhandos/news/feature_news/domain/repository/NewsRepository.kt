package com.zhandos.news.feature_news.domain.repository

import com.zhandos.news.feature_news.data.data_source.network.common.Category
import com.zhandos.news.feature_news.data.data_source.network.common.Sort
import com.zhandos.news.feature_news.domain.model.News
import com.zhandos.news.feature_news.domain.model.NewsSource

interface NewsRepository {

    suspend fun getEverything(sortBy: Sort = Sort.RELEVANCY): News

    suspend fun getTopHeadlines(
        country: String = "us",
        category: Category = Category.SCIENCE
    ): News

    suspend fun getSources(
        county: String = "us",
        category: Category = Category.GENERAL
    ): NewsSource

}