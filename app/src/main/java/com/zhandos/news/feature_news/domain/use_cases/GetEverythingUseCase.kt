package com.zhandos.news.feature_news.domain.use_cases

import com.zhandos.news.feature_news.common.Resource
import com.zhandos.news.feature_news.data.data_source.network.common.Sort
import com.zhandos.news.feature_news.domain.model.News
import com.zhandos.news.feature_news.domain.repository.NewsRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException

class GetEverythingUseCase(private val repository: NewsRepository) {
    operator fun invoke(sortBy: Sort = Sort.RELEVANCY): Flow<Resource<News>> = flow {
        try {
            emit(Resource.Loading<News>())
            val news = repository.getEverything(sortBy)
            emit(Resource.Success<News>(news))
        } catch (ex: HttpException) {
            emit(Resource.Error<News>(ex.localizedMessage ?: "An unexpected error occured"))
        } catch (ex: IOException) {
            emit(Resource.Error<News>("Couldn't reach server. Check your internet connection"))
        }
    }
}