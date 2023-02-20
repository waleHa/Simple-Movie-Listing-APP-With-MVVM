package com.wa7a.movierise.ui

import androidx.lifecycle.Observer
import androidx.recyclerview.widget.RecyclerView
import com.wa7a.movierise.R
import com.wa7a.movierise.data.model.State
import com.wa7a.movierise.databinding.ActivityMainBinding
import com.wa7a.movierise.ui.adapters.MovieAdapter

class MainActivity() :
    BaseActivity<ActivityMainBinding>() {

    override val layoutId: Int = R.layout.activity_main

    override fun setup() {
        binding.lifecycleOwner = this
        binding.viewmodel = viewModel

        var mainAdapter = MovieAdapter(mutableListOf(), viewModel)
        binding.recyclerView.adapter = mainAdapter

    }
}