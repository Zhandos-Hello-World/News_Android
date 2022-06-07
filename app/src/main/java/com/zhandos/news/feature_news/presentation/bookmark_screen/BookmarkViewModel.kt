package com.zhandos.news.feature_news.presentation.bookmark_screen

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.zhandos.news.feature_news.domain.model.Article
import com.zhandos.news.feature_news.domain.use_cases.NewsUseCases
import kotlinx.coroutines.launch
import javax.inject.Inject


class BookmarkViewModel @Inject constructor(private val useCases: NewsUseCases): ViewModel() {
    val lists = useCases.getNewsLocalUseCase()

    fun removeById(article: Article) {
        viewModelScope.launch {
            useCases.deleteLocalUseCase(article)
        }
    }
}