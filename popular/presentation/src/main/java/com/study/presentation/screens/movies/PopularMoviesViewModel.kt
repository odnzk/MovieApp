package com.study.presentation.screens.movies

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.study.common.State
import com.study.domain.usecase.FavoriteMoviesUsecases
import com.study.domain.usecase.MovieUsecases
import com.study.presentation.model.UiMovie
import com.study.presentation.util.mapper.toUiMovies
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class PopularMoviesViewModel @Inject constructor(
    private val movieUsecases: MovieUsecases,
    private val favoriteMoviesUsecases: FavoriteMoviesUsecases
) : ViewModel() {

    private var _movies: MutableStateFlow<State<List<UiMovie>>> =
        MutableStateFlow(State.Loading())
    val movies = _movies.asStateFlow()

    init {
        loadData()
    }

    private fun loadData() = viewModelScope.launch {
        combine(
            movieUsecases.getTopMovies(),
            favoriteMoviesUsecases.getFavoriteMoviesIds().distinctUntilChanged()
        ) { moviesState, favMoviesIds ->
            when (moviesState) {
                is State.Error -> moviesState.error?.let { _movies.value = State.Error(it) }
                is State.Loading -> _movies.value = State.Loading()
                is State.Success -> {
                    moviesState.data?.toUiMovies(favMoviesIds.toSet())?.also { uiMovies ->
                        _movies.value = State.Success(uiMovies)
                    }
                }
            }
        }.collect()
    }

    fun onEvent(event: PopularMoviesEvent) = viewModelScope.launch {
        when (event) {
            PopularMoviesEvent.TryAgain -> loadData()
            is PopularMoviesEvent.ToFavorite -> favoriteMoviesUsecases.addToFavoriteMovies(event.movie)
        }
    }
}
