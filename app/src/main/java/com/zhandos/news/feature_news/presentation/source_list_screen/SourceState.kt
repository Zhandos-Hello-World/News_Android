package com.zhandos.news.feature_news.presentation.source_list_screen

import com.zhandos.news.feature_news.domain.model.NewsSource

class SourceState(
    val isLoading: Boolean = false,
    val newsSource: NewsSource? = null,
    val error: String = ""
)