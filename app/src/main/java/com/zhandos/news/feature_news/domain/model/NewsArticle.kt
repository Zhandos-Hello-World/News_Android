package com.zhandos.news.feature_news.domain.model


data class NewsArticle(
    val status: String,
    val totalResults: Int,
    val articles: List<Article>,
)