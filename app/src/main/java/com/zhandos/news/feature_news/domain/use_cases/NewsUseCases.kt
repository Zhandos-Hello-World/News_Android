package com.zhandos.news.feature_news.domain.use_cases

class NewsUseCases(
    val getEverythingUseCase: GetEverythingUseCase,
    val getTopHeadlinesUseCase: GetTopHeadlinesUseCase,
    val getSourcesUseCase: GetSourcesUseCase
)