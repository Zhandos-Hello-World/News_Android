package com.zhandos.news.feature_news.presentation.tabs_screen

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.zhandos.news.databinding.FragmentSourceTabBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class SourceTabFragment : Fragment() {
    private var _binding: FragmentSourceTabBinding? = null
    val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentSourceTabBinding.inflate(inflater, container, false)

        return binding.root
    }


    override fun onDestroyView() {
        _binding = null
        super.onDestroyView()
    }


}