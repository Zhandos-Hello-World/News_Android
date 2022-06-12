package com.zhandos.news.feature_news.domain.model

import com.zhandos.news.feature_news.data.data_source.network.dto.SourceX

data class NewsSource(
    val sources: List<SourceX>,
    val status: String
)
