package com.zhandos.news.feature_news.data.data_source.network.dto


import com.google.gson.annotations.SerializedName
import com.zhandos.news.feature_news.domain.model.NewsSource

data class NewsSourceDto(
    @SerializedName("sources")
    val sourceDtos: List<SourceDto>,
    @SerializedName("status")
    val status: String
)

fun NewsSourceDto.toNewsSource(): NewsSource {
    return NewsSource(sourceDtos.map { it.toSource() }, status)
}
