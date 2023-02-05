package com.study.presentation.screens.movies

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
import com.google.android.material.snackbar.Snackbar
import com.study.common.State
import com.study.presentation.databinding.FragmentPopularMoviesBinding
import com.study.presentation.model.UiMovie
import com.study.presentation.navigation.fromMoviesToDetailedMovie
import com.study.presentation.util.recycler.MovieAdapter
import com.study.ui.*
import com.study.ui.databinding.StateLoadingBinding
import com.study.ui.databinding.StateNotFoundBinding
import com.study.ui.recycler.SimpleVerticalDividerItemDecorator
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

@AndroidEntryPoint
class PopularMoviesFragment : Fragment(), SearchFragment<UiMovie> {
    private var _binding: FragmentPopularMoviesBinding? = null
    private val binding: FragmentPopularMoviesBinding get() = _binding!!

    private var _loadingBinding: StateLoadingBinding? = null
    private val loadingBinding: StateLoadingBinding get() = _loadingBinding!!

    private var _notFoundBinding: StateNotFoundBinding? = null
    private val notFoundBinding: StateNotFoundBinding get() = _notFoundBinding!!

    private val moviesAdapter = MovieAdapter()

    private val viewModel by viewModels<PopularMoviesViewModel>()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentPopularMoviesBinding.inflate(inflater, container, false)
        _loadingBinding = StateLoadingBinding.bind(binding.root)
        _notFoundBinding = StateNotFoundBinding.bind(binding.root)

        setupAdapter()
        return binding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        notFoundBinding.hide()
        initRecyclerView()
        observeMovies()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _notFoundBinding = null
        _loadingBinding = null
        _binding = null
    }

    private fun initRecyclerView() {
        with(binding.rvPopular) {
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


    private fun setupAdapter() {
        moviesAdapter.run {
            onMovieClick = { movieId ->
                findNavController().fromMoviesToDetailedMovie(movieId)
            }
            onLongClick = { movie ->
                viewModel.onEvent(PopularMoviesEvent.ToFavorite(movie))
                Snackbar.make(binding.root, R.string.saved_to_favorites, Snackbar.LENGTH_SHORT)
                    .show()
            }
        }
    }

    override fun onSearchQueryChanged(query: String?) {
        viewModel.movies.value.data?.let { movies -> search(query, movies) }
    }

    override fun search(query: String?, data: List<UiMovie>) {
        val filtered = query?.let {
            data.filter { movie ->
                movie.title.lowercase().contains(query.lowercase())
            }
        } ?: data
        if (filtered.isEmpty()) {
            notFoundBinding.show()
        } else {
            notFoundBinding.hide()
        }
        moviesAdapter.submitList(filtered)
    }
}
