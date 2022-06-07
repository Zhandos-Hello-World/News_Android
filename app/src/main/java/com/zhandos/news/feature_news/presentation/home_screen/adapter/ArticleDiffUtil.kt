package com.zhandos.news.feature_news.presentation.home_screen.adapter

import androidx.recyclerview.widget.DiffUtil
import com.zhandos.news.feature_news.domain.model.Article

class ArticleDiffUtil: DiffUtil.ItemCallback<Article>() {

    override fun areItemsTheSame(oldItem: Article, newItem: Article): Boolean {
        return oldItem == newItem
    }

    override fun areContentsTheSame(oldItem: Article, newItem: Article): Boolean {
        return oldItem == newItem
    }
}