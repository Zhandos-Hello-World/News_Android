package com.zhandos.news.feature_news.presentation.source_list_screen

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import com.zhandos.news.databinding.FragmentSourceListBinding
import com.zhandos.news.feature_news.presentation.source_list_screen.adapter.SourceAdapter
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class SourceListFragment : Fragment() {
    private var _binding: FragmentSourceListBinding? = null
    val binding get() = _binding!!

    @Inject
    lateinit var viewModel: SourceViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentSourceListBinding.inflate(inflater, container, false)

        val view = binding.root

        val adapter = SourceAdapter {
            val url = it
            val intent = Intent(Intent.ACTION_VIEW)
            intent.data = Uri.parse(url)
            startActivity(intent)
        }

        viewModel.status.observe(viewLifecycleOwner, Observer {
            adapter.submitList(it.newsSource?.sources ?: emptyList())
        })

        binding.lifecycleOwner = this
        binding.listView.adapter = adapter

        return view
    }

    override fun onDestroyView() {
        _binding = null
        super.onDestroyView()
    }
}