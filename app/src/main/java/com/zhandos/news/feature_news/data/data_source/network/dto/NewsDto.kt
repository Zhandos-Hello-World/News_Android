package com.zhandos.news.feature_news.data.data_source.network.dto


import com.google.gson.annotations.SerializedName
import com.zhandos.news.feature_news.domain.model.NewsArticle

data class NewsDto(
    @SerializedName("articles")
    val articleDto: List<ArticleDto>,
    @SerializedName("status")
    val status: String,
    @SerializedName("totalResults")
    val totalResults: Int
)

fun NewsDto.toNews(): NewsArticle {
    return NewsArticle(status, totalResults, articleDto.map { it.toArticle() })
}