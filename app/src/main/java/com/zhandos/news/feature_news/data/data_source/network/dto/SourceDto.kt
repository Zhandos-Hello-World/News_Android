package com.zhandos.news.feature_news.data.data_source.network.dto


import com.google.gson.annotations.SerializedName
import com.zhandos.news.feature_news.domain.model.Source

data class SourceDto(
    @SerializedName("category")
    val category: String,
    @SerializedName("country")
    val country: String,
    @SerializedName("description")
    val description: String,
    @SerializedName("id")
    val id: String,
    @SerializedName("language")
    val language: String,
    @SerializedName("name")
    val name: String,
    @SerializedName("url")
    val url: String
)

fun SourceDto.toSource(): Source {
    return Source(category, country, description, id, language, name, url)
}