package com.zhandos.news.feature_news.domain.repository

import androidx.lifecycle.LiveData
import com.zhandos.news.feature_news.domain.model.Article


interface NewsLocalRepository {

    fun getAll(): LiveData<List<Article>>

    fun getById(id: Long): LiveData<Article>

    suspend fun delete(article: Article)

    suspend fun insert(article: Article)

}