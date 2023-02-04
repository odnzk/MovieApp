package com.study.presentation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.recyclerview.widget.LinearLayoutManager
import com.study.common.State
import com.study.presentation.databinding.FragmentFavoritesBinding
import com.study.ui.*
import com.study.ui.databinding.StateLoadingBinding
import com.study.ui.databinding.StateNotFoundBinding
import com.study.ui.recycler.MovieAdapter
import com.study.ui.recycler.SimpleVerticalDividerItemDecorator
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch


class FavoritesFragment : Fragment(), SearchFragment {
    private var _binding: FragmentFavoritesBinding? = null
    private val binding: FragmentFavoritesBinding get() = _binding!!

    private var _loadingBinding: StateLoadingBinding? = null
    private val loadingBinding: StateLoadingBinding get() = _loadingBinding!!

    private var _notFoundBinding: StateNotFoundBinding? = null
    private val notFoundBinding: StateNotFoundBinding get() = _notFoundBinding!!

    private val moviesAdapter = MovieAdapter()
    private val viewModel by viewModels<FavoriteMoviesViewModel>()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentFavoritesBinding.inflate(inflater, container, false)
        _loadingBinding = StateLoadingBinding.bind(binding.root)
        _notFoundBinding = StateNotFoundBinding.bind(binding.root)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        notFoundBinding.hide()
        initRecyclerView()
        observeFavoriteMovies()
    }

    private fun observeFavoriteMovies() {
        lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.STARTED) {
                viewModel.movies.collectLatest { state ->
                    when (state) {
                        is State.Loading -> loadingBinding.loadingStarted()
                        is State.Error -> state.error?.let { error ->
                            loadingBinding.errorOccurred(error) {
                                viewModel.onEvent(FavoriteMoviesEvent.TryAgain)
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

    private fun initRecyclerView() {
        with(binding.rvFavorites) {
            layoutManager = LinearLayoutManager(context)
            addItemDecoration(
                SimpleVerticalDividerItemDecorator
                    (
                    resources.getDimension(com.study.ui.R.dimen.recycler_view_vertical_divider)
                        .toInt()
                )
            )
            adapter = moviesAdapter
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _notFoundBinding = null
        _loadingBinding = null
        _binding = null
    }

    override fun onSearchQueryChanged(query: String?) {
        viewModel.movies.value.data?.let { movies ->
            searchMovies(
                query = query,
                notFoundBinding = notFoundBinding,
                movies = movies
            ) { resultList ->
                moviesAdapter.submitList(resultList)
            }
        }
    }
}
