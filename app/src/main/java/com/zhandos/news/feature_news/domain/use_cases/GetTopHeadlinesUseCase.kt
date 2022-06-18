package com.zhandos.news.feature_news.domain.use_cases

import com.zhandos.news.feature_news.common.Resource
import com.zhandos.news.feature_news.data.data_source.network.common.Category
import com.zhandos.news.feature_news.domain.model.NewsArticle
import com.zhandos.news.feature_news.domain.repository.NewsRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException

class GetTopHeadlinesUseCase(private val repository: NewsRepository) {
    operator fun invoke(
        country: String = "us",
        category: Category = Category.GENERAL
    ): Flow<Resource<NewsArticle>> = flow {
        try {
            emit(Resource.Loading<NewsArticle>())
            val news = repository.getTopHeadlines(country, category)
            emit(Resource.Success<NewsArticle>(news))
        } catch (ex: HttpException) {
            emit(Resource.Error<NewsArticle>(ex.localizedMessage ?: "An unexpected error occured"))
        } catch (ex: IOException) {
            emit(Resource.Error<NewsArticle>("Couldn't reach server. Check your internet connection"))
        }
    }
}