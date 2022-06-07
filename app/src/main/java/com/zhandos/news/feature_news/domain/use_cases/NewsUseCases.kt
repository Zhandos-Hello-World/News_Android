package com.zhandos.news.feature_news.domain.use_cases

class NewsUseCases(
    val getNewsRemoteUseCase: GetNewsRemoteUseCase,
    val addNewsLocalUseCase: AddNewsLocalUseCase,
    val getNewLocalUseCase: GetNewLocalUseCase,
    val getNewsLocalUseCase: GetNewsLocalUseCase,
    val deleteLocalUseCase: DeleteLocalUseCase
)