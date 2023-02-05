package com.study.favorite

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.LinearLayoutManager
import com.study.common.State
import com.study.favorite.databinding.FragmentFavoritesBinding
import com.study.favorite.mapper.toMovie
import com.study.favorite.model.UiMovie
import com.study.favorite.recycler.UiMovieAdapter
import com.study.ui.*
import com.study.ui.databinding.StateLoadingBinding
import com.study.ui.databinding.StateNotFoundBinding
import com.study.ui.recycler.SimpleVerticalDividerItemDecorator
import com.study.ui.recycler.SwipeCallback
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch


@AndroidEntryPoint
class FavoritesFragment : Fragment(), SearchFragment<UiMovie> {
    private var _binding: FragmentFavoritesBinding? = null
    private val binding: FragmentFavoritesBinding get() = _binding!!

    private var _loadingBinding: StateLoadingBinding? = null
    private val loadingBinding: StateLoadingBinding get() = _loadingBinding!!

    private var _notFoundBinding: StateNotFoundBinding? = null
    private val notFoundBinding: StateNotFoundBinding get() = _notFoundBinding!!

    private val moviesAdapter = UiMovieAdapter()
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
            val swipeCallback = SwipeCallback(moviesAdapter) { uimovie ->
                (uimovie as? UiMovie)?.toMovie()?.also {
                    viewModel.onEvent(FavoriteMoviesEvent.RemoveFromFavorite(it))
                }
            }
            val itemTouchHelper = ItemTouchHelper(swipeCallback)
            itemTouchHelper.attachToRecyclerView(this)
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
