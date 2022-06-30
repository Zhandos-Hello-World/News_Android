package com.zhandos.news.feature_news.presentation.home_screen

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.google.android.material.tabs.TabLayoutMediator
import com.zhandos.news.databinding.FragmentHomeBinding
import com.zhandos.news.feature_news.data.data_source.network.common.Category
import com.zhandos.news.feature_news.presentation.home_screen.viewpager_adapter.ArticlesPagerAdapter
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject


@AndroidEntryPoint
class HomeViewPagerFragment : Fragment() {
    private var _binding: FragmentHomeBinding? = null
    val binding get() = _binding!!

    @Inject
    lateinit var viewModel: HomeViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentHomeBinding.inflate(inflater, container, false)

        val viewPager = binding.pager
        val tabLayout = binding.tabLayout

        viewPager.adapter = ArticlesPagerAdapter(this, Category.values())


        TabLayoutMediator(tabLayout, viewPager) { tab, position ->
            tab.text = getTabTitle(position)
        }.attach()

        return binding.root
    }

    private fun getTabTitle(position: Int): String {
        return Category.values()[position].name
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}