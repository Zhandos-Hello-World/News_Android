package com.zhandos.news.feature_news.data.data_source

import com.zhandos.news.feature_news.domain.model.News
import retrofit2.http.GET


interface NewsApiHolder {
    @GET("everything?q=keyword&apiKey=a179edcffc604bd98a3a16360b76e4b0")
    suspend fun getAllNewsResponse(): News
}