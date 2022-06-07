package com.zhandos.news.feature_news.domain.model

import com.squareup.moshi.Json


data class News(
    @Json(name="status")
    val status: String,
    @Json(name="totalResults")
    val totalResults: Int,
    @Json(name = "articles")
    val articles: List<Article>
)