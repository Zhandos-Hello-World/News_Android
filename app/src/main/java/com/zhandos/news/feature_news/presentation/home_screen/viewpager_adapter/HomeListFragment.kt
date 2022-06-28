package com.zhandos.news.feature_news.presentation.home_screen.viewpager_adapter

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import com.zhandos.news.databinding.FragmentHomeListBinding
import com.zhandos.news.feature_news.data.data_source.network.common.Category
import com.zhandos.news.feature_news.presentation.home_screen.adapter.ArticleAdapter
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class HomeListFragment(val category: Category) : Fragment() {
    private var _binding: FragmentHomeListBinding? = null
    val binding get() = _binding!!

    @Inject
    lateinit var viewModel: HomeListViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentHomeListBinding.inflate(inflater, container, false)
        val view = binding.root

        val adapter = ArticleAdapter {

        }
        binding.listItem.adapter = adapter

        viewModel.status.observe(viewLifecycleOwner, Observer {
            adapter.submitList(it.newsArticle?.articles ?: emptyList())
        })

        binding.lifecycleOwner = this
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        getData()
    }

    private fun getData() {
        viewModel.getData(category)
    }


    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}