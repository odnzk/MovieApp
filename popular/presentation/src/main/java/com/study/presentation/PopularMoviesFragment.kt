package com.study.presentation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.study.presentation.databinding.FragmentPopularMoviesBinding
import com.study.presentation.recycler.MovieAdapter

class PopularMoviesFragment : Fragment() {
    private var _binding: FragmentPopularMoviesBinding? = null
    private val binding: FragmentPopularMoviesBinding get() = _binding!!

    private val moviesAdapter = MovieAdapter()

    private fun setupAdapter() {
        moviesAdapter.run {
//            glide = Glide.with(this@PopularMoviesFragment)
            onMovieClick = {
                // todo navigate to detailed screen
            }
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentPopularMoviesBinding.inflate(inflater, container, false)
        setupAdapter()
        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
