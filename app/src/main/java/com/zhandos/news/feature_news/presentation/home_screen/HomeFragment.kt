package com.zhandos.news.feature_news.presentation.home_screen

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.zhandos.news.databinding.FragmentHomeBinding
import com.zhandos.news.feature_news.presentation.home_screen.adapter.ArticleAdapter
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class HomeFragment: Fragment() {
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


        val adapter = ArticleAdapter()
        binding.listItem.adapter = adapter

        viewModel.status.observe(viewLifecycleOwner, Observer {
            adapter.submitList(it.articles)
        })


        binding.lifecycleOwner = this
        binding.viewModel = viewModel

        return view
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}