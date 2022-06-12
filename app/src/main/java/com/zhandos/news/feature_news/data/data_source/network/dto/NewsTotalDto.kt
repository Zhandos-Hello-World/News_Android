package com.zhandos.news.feature_news.data.data_source.network.dto

import com.zhandos.news.feature_news.domain.model.Article
import com.zhandos.news.feature_news.domain.model.News

data class NewsTotalDto(
    val status: String,
    val totalResults: Int,
    val articles: List<Article>
)

fun NewsTotalDto.toNews(): News {
    return News(status, totalResults, articles)
}