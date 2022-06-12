package com.zhandos.news.feature_news.data.data_source.network.dto

import com.zhandos.news.feature_news.domain.model.NewsSource

data class NewsSourceDto(
    val sources: List<SourceX>,
    val status: String
)

fun NewsSourceDto.toSource(): NewsSource {
    return NewsSource(sources, status)
}
