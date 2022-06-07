package com.zhandos.news.di

import android.app.Application
import androidx.room.Room
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import com.zhandos.news.feature_news.data.data_source.local.NewsDatabase
import com.zhandos.news.feature_news.data.data_source.network.NewsApi
import com.zhandos.news.feature_news.data.data_source.network.NewsApiHolder
import com.zhandos.news.feature_news.data.repository.NewsLocalRepositoryImpl
import com.zhandos.news.feature_news.data.repository.NewsNetworkRepositoryImpl
import com.zhandos.news.feature_news.domain.repository.NewsLocalRepository
import com.zhandos.news.feature_news.domain.repository.NewsNetworkRepository
import com.zhandos.news.feature_news.domain.use_cases.*
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
    fun provideNewsUseCases(
        repository: NewsNetworkRepository,
        localRepository: NewsLocalRepository
    ): NewsUseCases {
        return NewsUseCases(
            GetNewsRemoteUseCase(repository),
            AddNewsLocalUseCase(localRepository),
            GetNewLocalUseCase(localRepository),
            GetNewsLocalUseCase(localRepository),
            DeleteLocalUseCase(localRepository)
        )
    }


    //Room
    @Provides
    @Singleton
    fun provideDatabase(application: Application): NewsDatabase {
        return Room.databaseBuilder(
            application,
            NewsDatabase::class.java,
            "NewsDatabase"
        ).build()
    }

    @Provides
    @Singleton
    fun provideRepository(newsDatabase: NewsDatabase): NewsLocalRepository {
        return NewsLocalRepositoryImpl(newsDatabase.dao)
    }


}