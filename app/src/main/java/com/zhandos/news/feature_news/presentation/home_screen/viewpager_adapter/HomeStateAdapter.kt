package com.zhandos.news.feature_news.presentation.home_screen.viewpager_adapter

import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.zhandos.news.feature_news.data.data_source.network.common.Category

class HomeStateAdapter(fragment: Fragment, private val categories: Array<Category>) : FragmentStateAdapter(fragment) {


    override fun getItemCount(): Int {
        return categories.size
    }

    override fun createFragment(position: Int): Fragment {
        return HomeListFragment(categories[position])
    }

}