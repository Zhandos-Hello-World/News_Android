package com.zhandos.news.feature_news.domain.use_cases

import com.zhandos.news.feature_news.common.Resource
import com.zhandos.news.feature_news.data.data_source.network.common.Category
import com.zhandos.news.feature_news.domain.model.NewsSource
import com.zhandos.news.feature_news.domain.repository.NewsRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException

class GetSourcesUseCase(private val repository: NewsRepository) {
    operator fun invoke(
        county: String = "us",
        category: Category = Category.GENERAL
    ): Flow<Resource<NewsSource>> = flow {
        try {
            emit(Resource.Loading<NewsSource>())
            val source = repository.getSources(county, category)
            emit(Resource.Success<NewsSource>(source))
        } catch (ex: HttpException) {
            emit(Resource.Error<NewsSource>(ex.localizedMessage ?: "An unexpected error occured"))
        } catch (ex: IOException) {
            emit(Resource.Error<NewsSource>("Couldn't reach server. Check your internet connection"))
        }
    }
}