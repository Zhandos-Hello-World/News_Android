package com.zhandos.news.feature_news.data.data_source.network

import com.zhandos.news.feature_news.common.Constants
import com.zhandos.news.feature_news.data.data_source.network.common.Category
import com.zhandos.news.feature_news.data.data_source.network.common.Sort
import com.zhandos.news.feature_news.data.data_source.network.dto.NewsDto
import com.zhandos.news.feature_news.data.data_source.network.dto.NewsSourceDto
import com.zhandos.news.feature_news.domain.model.NewsSource
import retrofit2.http.GET
import retrofit2.http.Query


interface NewsApiHolder {

    /*  TODO EVERYTHING
        Parameters which we can use for getEverything:)
        q(must for Everything) -> Keywords or phrases to search for in the article title and body.
        searchIn -> The fields to restrict your q search to.,
        sources,
        domains,
        excludeDomains,
        from,
        to,
        language,
        pageSize,
        page.
     */
    @GET("/v2/everything?q=keyword&apiKey=${Constants.API_KEY}")
    suspend fun getEverything(
        @Query("sortBy") sortBy: Sort = Sort.RELEVANCY,
    ): NewsDto


    /*  TODO TOP-HEADLINES
    Parameters which we can use for topHeadlines:)
    country,
    category,
    sources,
    q,
    pageSize,
    page
    */
    @GET("/v2/top-headlines?apiKey=${Constants.API_KEY}")
    suspend fun getTopHeadlines(
        @Query("country") country: String = "us",
        @Query("category") category: Category = Category.SCIENCE
    ): NewsDto


    /*  TODO SOURCES
    Parameters which we can use for sources:)
    category,
    language,
    country
    */
    @GET("/v2/top-headlines/sources?apiKey=${Constants.API_KEY}")
    suspend fun getSources(
        @Query("country") county: String = "us",
        @Query("category") category: Category = Category.GENERAL
    ): NewsSourceDto
}