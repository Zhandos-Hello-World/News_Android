package com.zhandos.news.feature_news.domain.model


data class Article(
    val author: String?,
    val title: String?,
    val description: String?,
    val url: String?,
    val urlToImage: String?,
    val publishedAt: String?,
    val content: String?
) {
    fun getShortTitle(): String? {
        if (title == null) {
            return title
        }
        var short = title
        if (title.length >= 36) {
            short = title.substring(0, 36)
            short = "$short..."
        }
        return short
    }


    fun getShortTime(): String? {
        if (publishedAt == null) {
            return publishedAt
        }
        return publishedAt.substring(0, publishedAt.indexOf('T'))
    }
}