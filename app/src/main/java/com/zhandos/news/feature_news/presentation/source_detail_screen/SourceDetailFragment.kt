package com.zhandos.news.feature_news.presentation.source_detail_screen

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.zhandos.news.databinding.FragmentSourceDetailBinding

class SourceDetailFragment : Fragment() {
    private var _binding: FragmentSourceDetailBinding? = null
    val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentSourceDetailBinding.inflate(inflater, container, false)
        val view = binding.root


        return view
    }

    override fun onDestroyView() {
        _binding = null
        super.onDestroyView()
    }
}