package com.zhandos.news.feature_news.data.data_source.network.dto


import com.google.gson.annotations.SerializedName
import com.zhandos.news.feature_news.domain.model.Article

data class ArticleDto(
    @SerializedName("author")
    val author: String?,
    @SerializedName("content")
    val content: String?,
    @SerializedName("description")
    val description: String?,
    @SerializedName("publishedAt")
    val publishedAt: String?,
    @SerializedName("source")
    val sourceDto: SourceInternal?,
    @SerializedName("title")
    val title: String?,
    @SerializedName("url")
    val url: String?,
    @SerializedName("urlToImage")
    val urlToImage: String?
) {

    data class SourceInternal(
        @SerializedName("id")
        val id: String?,
        @SerializedName("name")
        val name: String?
    )
}

fun ArticleDto.toArticle(): Article {
    return Article(author, title, description, url, urlToImage, publishedAt, content)
}