package com.zhandos.news.di

import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import com.zhandos.news.feature_news.data.data_source.NewsApi
import com.zhandos.news.feature_news.data.data_source.NewsApiHolder
import com.zhandos.news.feature_news.data.repository.NewsNetworkRepositoryImpl
import com.zhandos.news.feature_news.domain.repository.NewsNetworkRepository
import com.zhandos.news.feature_news.domain.use_cases.GetNewsUseCase
import com.zhandos.news.feature_news.domain.use_cases.NewsUseCases
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideMoshi(): Moshi {
        return Moshi.Builder()
            .add(KotlinJsonAdapterFactory())
            .build()
    }

    @Provides
    @Singleton
    fun provideRetrofit(moshi: Moshi): Retrofit {
        return NewsApi.retrofit(moshi)
    }

    @Provides
    @Singleton
    fun provideNewApiHolder(retrofit: Retrofit): NewsApiHolder {
        return retrofit.create(NewsApiHolder::class.java)
    }

    @Provides
    @Singleton
    fun provideNewsNetworkRepository(newsApiHolder: NewsApiHolder): NewsNetworkRepository {
        return NewsNetworkRepositoryImpl(newsApiHolder)
    }

    @Provides
    @Singleton
    fun provideNewsUseCases(repository: NewsNetworkRepository): NewsUseCases {
        return NewsUseCases(
            GetNewsUseCase(repository)
        )
    }

}