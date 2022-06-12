package com.zhandos.news.feature_news.data.data_source.network.common

import com.google.gson.annotations.SerializedName

enum class SearchIn(val type: String) {

    @SerializedName("title")
    TITLE("title"),

    @SerializedName("description")
    DESCRIPTION("description"),

    @SerializedName("content")
    CONTENT("content"),


}