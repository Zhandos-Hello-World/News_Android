package com.zhandos.news.feature_news.data.data_source.local

import androidx.lifecycle.LiveData
import androidx.room.*
import com.zhandos.news.feature_news.domain.model.Article

@Dao
interface NewsDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(article: Article)

    @Delete
    suspend fun delete(article: Article)

    @Query("SELECT * FROM Article")
    fun getAll(): LiveData<List<Article>>

    @Query("SELECT * FROM Article WHERE id = :id")
    fun getById(id: Long): LiveData<Article>

    @Query("SELECT * FROM Article WHERE title=:title")
    fun getByTitle(title: String): LiveData<Article>

    @Query("SELECT COUNT(*) FROM Article")
    fun getSize(): Long
}