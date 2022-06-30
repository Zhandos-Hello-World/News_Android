package com.zhandos.news.di

import com.zhandos.news.feature_news.common.Constants
import com.zhandos.news.feature_news.data.data_source.network.NewsApiHolder
import com.zhandos.news.feature_news.data.repository.NewsRepositoryImpl
import com.zhandos.news.feature_news.domain.repository.NewsRepository
import com.zhandos.news.feature_news.domain.use_cases.GetEverythingUseCase
import com.zhandos.news.feature_news.domain.use_cases.GetSourcesUseCase
import com.zhandos.news.feature_news.domain.use_cases.GetTopHeadlinesUseCase
import com.zhandos.news.feature_news.domain.use_cases.NewsUseCases
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.scopes.ViewModelScoped
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideNewApiHolder(): NewsApiHolder {
        return Retrofit.Builder()
            .baseUrl(Constants.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(NewsApiHolder::class.java)
    }

    @Provides
    @Singleton
    fun provideNewsNetworkRepository(newsApiHolder: NewsApiHolder): NewsRepository {
        return NewsRepositoryImpl(newsApiHolder)
    }

    @Provides
    fun provideNewsUseCases(
        repository: NewsRepository
    ): NewsUseCases {
        return NewsUseCases(
            GetEverythingUseCase(repository),
            GetTopHeadlinesUseCase(repository),
            GetSourcesUseCase(repository)
        )
    }


//    //Room
//    @Provides
//    @Singleton
//    fun provideDatabase(application: Application): NewsDatabase {
//        return Room.databaseBuilder(
//            application,
//            NewsDatabase::class.java,
//            "NewsDatabase"
//        ).build()
//    }
//
//    @Provides
//    @Singleton
//    fun provideRepository(newsDatabase: NewsDatabase): NewsLocalRepository {
//        return NewsLocalRepositoryImpl(newsDatabase.dao)
//    }


}