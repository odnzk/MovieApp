package com.study.presentation.movies

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.study.common.State
import com.study.presentation.databinding.FragmentPopularMoviesBinding
import com.study.presentation.movies.recycler.MovieAdapter
import com.study.presentation.movies.recycler.PopularMoviesEvent
import com.study.presentation.movies.recycler.SimpleVerticalDividerItemDecorator
import com.study.presentation.navigation.fromMoviesToDetailedMovie
import com.study.ui.R
import com.study.ui.databinding.StateLoadingBinding
import com.study.ui.errorOccurred
import com.study.ui.loadingFinished
import com.study.ui.loadingStarted
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

@AndroidEntryPoint
class PopularMoviesFragment : Fragment() {
    private var _binding: FragmentPopularMoviesBinding? = null
    private val binding: FragmentPopularMoviesBinding get() = _binding!!

    private var _loadingBinding: StateLoadingBinding? = null
    private val loadingBinding: StateLoadingBinding get() = _loadingBinding!!


    private val moviesAdapter = MovieAdapter()
    private val viewModel by viewModels<PopularMoviesViewModel>()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        observeMovies()
        initRecyclerView()
    }

    private fun initRecyclerView() {
        with(binding.rvPopular) {
            // todo item vidiver to int??
            layoutManager = LinearLayoutManager(context)
            addItemDecoration(
                SimpleVerticalDividerItemDecorator
                    (resources.getDimension(R.dimen.recycler_view_vertical_divider).toInt())
            )
            adapter = moviesAdapter
        }
    }

    private fun observeMovies() {
        lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.STARTED) {
                viewModel.movies.collectLatest { state ->
                    when (state) {
                        is State.Loading -> loadingBinding.loadingStarted()
                        is State.Error -> state.error?.let { error ->
                            loadingBinding.errorOccurred(error) {
                                viewModel.onEvent(PopularMoviesEvent.TryAgain)
                            }
                        }
                        is State.Success -> {
                            state.data?.let { movies ->
                                loadingBinding.loadingFinished()
                                moviesAdapter.submitList(movies)
                            }
                        }
                    }
                }
            }
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentPopularMoviesBinding.inflate(inflater, container, false)
        _loadingBinding = StateLoadingBinding.bind(binding.root)
        setupAdapter()
        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _loadingBinding = null
        _binding = null
    }

    private fun setupAdapter() {
        moviesAdapter.run {
            onMovieClick = { movieId ->
                findNavController().fromMoviesToDetailedMovie(movieId)
            }
        }
    }
}
