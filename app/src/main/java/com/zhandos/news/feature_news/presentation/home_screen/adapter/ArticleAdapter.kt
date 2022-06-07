package com.zhandos.news.feature_news.presentation.home_screen.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.zhandos.news.databinding.ItemArticleBinding
import com.zhandos.news.feature_news.domain.model.Article

class ArticleAdapter(private val listener: (article: Article) -> Unit) : ListAdapter<Article, ArticleAdapter.ArticleViewHolder>(ArticleDiffUtil()) {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        ArticleViewHolder.inflate(parent)

    override fun onBindViewHolder(holder: ArticleViewHolder, position: Int) {
        holder.bind(getItem(position), listener)
    }


    class ArticleViewHolder(private val binding: ItemArticleBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(article: Article, listener: (article: Article) -> Unit) {
            binding.article = article

            binding.addBookmark.setOnClickListener {
                listener(article)
            }
        }

        companion object {
            fun inflate(parent: ViewGroup): ArticleViewHolder {
                val inflater = LayoutInflater.from(parent.context)
                val binding = ItemArticleBinding.inflate(inflater, parent, false)
                return ArticleViewHolder(binding)
            }
        }
    }


}