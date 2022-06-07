package com.zhandos.news.feature_news.data.data_source.local

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.zhandos.news.feature_news.domain.model.Article

@Dao
interface NewsDao {

    @Insert
    suspend fun insert(article: Article)

    @Delete
    suspend fun delete(article: Article)

    @Query("SELECT * FROM Article")
    fun getAll(): LiveData<List<Article>>

    @Query("SELECT * FROM Article WHERE id = :id")
    fun getById(id: Long): LiveData<Article>
}