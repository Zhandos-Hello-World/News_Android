package com.zhandos.news.feature_news.data.data_source.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.zhandos.news.feature_news.domain.model.Article

@Database(entities = [Article::class], version = 1, exportSchema = false)
abstract class NewsDatabase : RoomDatabase() {
    abstract val dao: NewsDao
}