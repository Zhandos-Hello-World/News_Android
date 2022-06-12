package com.zhandos.news.feature_news.data.data_source.network.common

import com.google.gson.annotations.SerializedName

enum class Category {
    @SerializedName("business")
    BUSINESS,
    @SerializedName("entertainment")
    ENTERTAINMENT,
    @SerializedName("general")
    GENERAL,
    @SerializedName("health")
    HEALTH,
    @SerializedName("science")
    SCIENCE,
    @SerializedName("sports")
    SPORTS,
    @SerializedName("technology")
    TECHNOLOGY
}