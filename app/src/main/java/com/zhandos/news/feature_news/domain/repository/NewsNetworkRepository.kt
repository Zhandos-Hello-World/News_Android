package com.zhandos.news.feature_news.domain.repository

import androidx.lifecycle.MutableLiveData
import com.zhandos.news.feature_news.domain.model.News

interface NewsNetworkRepository {

    suspend fun getAll(): News
}