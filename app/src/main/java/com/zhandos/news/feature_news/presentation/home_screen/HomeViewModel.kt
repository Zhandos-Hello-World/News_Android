package com.zhandos.news.feature_news.presentation.home_screen

import androidx.lifecycle.ViewModel
import com.zhandos.news.feature_news.domain.use_cases.NewsUseCases
import javax.inject.Inject


class HomeViewModel @Inject constructor(private val useCases: NewsUseCases) : ViewModel()