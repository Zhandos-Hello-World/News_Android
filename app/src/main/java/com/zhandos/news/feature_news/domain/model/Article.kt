package com.zhandos.news.feature_news.domain.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.Ignore
import androidx.room.PrimaryKey
import com.squareup.moshi.Json

@Entity(tableName = "Article")
data class Article(
    @Json(ignore = true)
    @PrimaryKey(autoGenerate = true)
    var id: Long = 0L,
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