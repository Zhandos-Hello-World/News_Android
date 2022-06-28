package com.zhandos.news.feature_news.presentation.home_screen

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.google.android.material.tabs.TabLayoutMediator
import com.zhandos.news.databinding.FragmentHomeBinding
import com.zhandos.news.feature_news.data.data_source.network.common.Category
import com.zhandos.news.feature_news.presentation.home_screen.viewpager_adapter.HomeStateAdapter
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject


@AndroidEntryPoint
class HomeFragment : Fragment() {
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
        val view = binding.root


//        val adapter = ArticleAdapter {
//            //viewModel.addData(it)
//            val value = "Added - " + it.title
//            val snack: Snackbar = Snackbar.make(view, value, Snackbar.LENGTH_SHORT)
//
//            snack.setBackgroundTint(Color.rgb(0, 133, 66))
//            val view = snack.view
//            val params = view.layoutParams as FrameLayout.LayoutParams
//            params.gravity = Gravity.TOP
//            view.layoutParams = params
//
//            snack.show()
//        }

//        val viewPagerAdapter = CategoryViewPagerAdapter(Category.values())
//        binding.pager.adapter = viewPagerAdapter

        binding.lifecycleOwner = this

        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val homeStateAdapter = HomeStateAdapter(this, Category.values())
        binding.pager.adapter = homeStateAdapter
        TabLayoutMediator(binding.tabLayout, binding.pager) { tab, position ->
            if (position in Category.values().indices) {
                tab.text = Category.values()[position].name
            }
        }.attach()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}