package com.study.presentation.movies

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.study.common.State
import com.study.domain.usecase.FavoriteMoviesUsecases
import com.study.domain.usecase.MovieUsecases
import com.study.presentation.mapper.toUiMovies
import com.study.presentation.model.UiMovie
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.combine
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
            favoriteMoviesUsecases.getFavoriteMoviesIds()
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
        }
    }

    fun onEvent(event: PopularMoviesEvent) = viewModelScope.launch {
        when (event) {
            PopularMoviesEvent.TryAgain -> loadData()
            is PopularMoviesEvent.ToFavorite -> favoriteMoviesUsecases.addToFavoriteMovies(event.movie)
        }
    }
}
