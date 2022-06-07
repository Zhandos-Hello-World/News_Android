package com.zhandos.news.feature_news.presentation.bookmark_screen.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.zhandos.news.databinding.ItemArticle2Binding
import com.zhandos.news.feature_news.domain.model.Article
import com.zhandos.news.feature_news.presentation.home_screen.adapter.ArticleDiffUtil

class BookmarkAdapter(private val listener: (article: Article) -> Unit) :
    ListAdapter<Article, BookmarkAdapter.BookmarkViewHolder>(ArticleDiffUtil()) {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        BookmarkViewHolder.inflate(parent)

    override fun onBindViewHolder(holder: BookmarkViewHolder, position: Int) {
        holder.bind(getItem(position), listener)
    }


    class BookmarkViewHolder(private val binding: ItemArticle2Binding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(article: Article, listener: (article: Article) -> Unit) {
            binding.article = article

            binding.removeBtn.setOnClickListener {
                listener(binding.article!!)
            }
        }

        companion object {
            fun inflate(parent: ViewGroup): BookmarkViewHolder {
                val inflater = LayoutInflater.from(parent.context)
                val binding = ItemArticle2Binding.inflate(inflater, parent, false)
                return BookmarkViewHolder(binding)
            }
        }
    }


}