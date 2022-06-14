package com.zhandos.news.feature_news.presentation.home_screen

import android.graphics.Color
import android.os.Bundle
import android.view.Gravity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.FrameLayout
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import com.google.android.material.snackbar.Snackbar
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


        val adapter = ArticleAdapter {
            //viewModel.addData(it)
            val value = "Added - " + it.title
            val snack: Snackbar = Snackbar.make(view, value, Snackbar.LENGTH_SHORT)

            snack.setBackgroundTint(Color.rgb(0, 133, 66))
            val view = snack.view
            val params = view.layoutParams as FrameLayout.LayoutParams
            params.gravity = Gravity.TOP
            view.layoutParams = params

            snack.show()
        }
        binding.listItem.adapter = adapter

        viewModel.status.observe(viewLifecycleOwner, Observer {
            adapter.submitList(it.news?.articles ?: emptyList())
        })


        binding.lifecycleOwner = this

        return view
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}