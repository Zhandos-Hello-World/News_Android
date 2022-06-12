package com.zhandos.news.feature_news.domain.model


data class News(
    val status: String,
    val totalResults: Int,
    val articles: List<Article>
)