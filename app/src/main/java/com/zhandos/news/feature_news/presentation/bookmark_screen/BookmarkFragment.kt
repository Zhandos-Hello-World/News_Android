package com.zhandos.news.feature_news.presentation.bookmark_screen

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.zhandos.news.databinding.FragmentBookmarkBinding
import com.zhandos.news.feature_news.presentation.bookmark_screen.adapter.BookmarkAdapter

class BookmarkFragment : Fragment() {
    private var _binding: FragmentBookmarkBinding? = null
    private val binding: FragmentBookmarkBinding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentBookmarkBinding.inflate(inflater, container, false)
        val view = binding.root

        val adapter = BookmarkAdapter {
            //remove action
        }




        return view
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}