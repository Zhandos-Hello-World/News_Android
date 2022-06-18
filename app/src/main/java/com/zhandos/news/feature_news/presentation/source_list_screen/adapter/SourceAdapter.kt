package com.zhandos.news.feature_news.presentation.source_list_screen.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.zhandos.news.databinding.ItemSourceBinding
import com.zhandos.news.feature_news.domain.model.Source

class SourceAdapter : ListAdapter<Source, SourceAdapter.SourceViewHolder>(SourceDiffUtil()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SourceViewHolder {
        return SourceViewHolder.inflate(parent)
    }

    override fun onBindViewHolder(holder: SourceViewHolder, position: Int) {
        val newsSource = getItem(position)
        holder.bind(newsSource)
    }


    class SourceViewHolder(private val binding: ItemSourceBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(newsSource: Source) {
            binding.newsSource = newsSource
        }

        companion object {
            fun inflate(parent: ViewGroup): SourceViewHolder {
                val inflater = LayoutInflater.from(parent.context)
                val binding = ItemSourceBinding.inflate(inflater, parent, false)
                return SourceViewHolder(binding)
            }
        }
    }
}