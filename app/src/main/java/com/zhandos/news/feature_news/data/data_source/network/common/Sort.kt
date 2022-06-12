package com.zhandos.news.feature_news.data.data_source.network.common

import com.google.gson.annotations.SerializedName

enum class Sort {
    @SerializedName("relevancy")
    RELEVANCY,
    @SerializedName("popularity")
    POPULARITY,
    @SerializedName("publishedAt")
    PUBLISHED_AT
}