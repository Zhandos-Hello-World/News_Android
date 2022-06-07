package com.zhandos.news.feature_news.domain.use_cases

class NewsUseCases(
    val getNewsRemoteUseCase: GetNewsRemoteUseCase,
    val addNewLocalUseCase: AddNewLocalUseCase,
    val getNewLocalUseCase: GetNewLocalUseCase,
    val getNewsLocalUseCase: GetNewsLocalUseCase,
    val deleteLocalUseCase: DeleteLocalUseCase
)