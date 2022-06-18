package com.zhandos.news.feature_news.presentation.home_screen

import com.zhandos.news.feature_news.domain.model.NewsArticle

class NewsState(
    val isLoading: Boolean = false,
    val newsArticle: NewsArticle? = null,
    val error: String = ""
)