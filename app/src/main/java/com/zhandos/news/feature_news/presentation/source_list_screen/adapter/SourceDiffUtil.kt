package com.zhandos.news.feature_news.presentation.source_list_screen.adapter

import androidx.recyclerview.widget.DiffUtil
import com.zhandos.news.feature_news.domain.model.Source

class SourceDiffUtil : DiffUtil.ItemCallback<Source>() {
    override fun areItemsTheSame(oldItem: Source, newItem: Source): Boolean {
        return oldItem == newItem
    }

    override fun areContentsTheSame(oldItem: Source, newItem: Source): Boolean {
        return oldItem == newItem
    }
}