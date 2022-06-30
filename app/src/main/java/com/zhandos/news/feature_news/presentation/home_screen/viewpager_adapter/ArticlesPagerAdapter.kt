package com.zhandos.news.feature_news.presentation.home_screen.viewpager_adapter

import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.zhandos.news.feature_news.data.data_source.network.common.Category

class ArticlesPagerAdapter(fragment: Fragment, private val categories: Array<Category>) :
    FragmentStateAdapter(fragment) {

    private val fragmentsCreator = Array<(category: Category) -> Fragment>(itemCount) {
        { HomeListFragment(it) }
    }

    override fun getItemCount(): Int {
        return categories.size
    }

    override fun createFragment(position: Int): Fragment {
        val category = categories[position]

        return fragmentsCreator[position].invoke(category)
    }

}