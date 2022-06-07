package com.zhandos.news.feature_news.presentation.bookmark_screen

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import com.zhandos.news.databinding.FragmentBookmarkBinding
import com.zhandos.news.feature_news.presentation.bookmark_screen.adapter.BookmarkAdapter
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class BookmarkFragment : Fragment() {
    private var _binding: FragmentBookmarkBinding? = null
    private val binding: FragmentBookmarkBinding get() = _binding!!

    @Inject
    lateinit var viewModel: BookmarkViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentBookmarkBinding.inflate(inflater, container, false)
        val view = binding.root


        val adapter = BookmarkAdapter {
            //remove action
            viewModel.removeById(it)
        }

        binding.listItem.adapter = adapter

        viewModel.lists.observe(viewLifecycleOwner, Observer {
            adapter.submitList(it)
        })


        return view
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}