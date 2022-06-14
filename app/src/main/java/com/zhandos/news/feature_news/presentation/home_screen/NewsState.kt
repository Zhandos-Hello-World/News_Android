package com.zhandos.news.feature_news.presentation.home_screen

import com.zhandos.news.feature_news.domain.model.News

class NewsState(
    val isLoading: Boolean = false,
    val news: News? = null,
    val error: String = ""
)