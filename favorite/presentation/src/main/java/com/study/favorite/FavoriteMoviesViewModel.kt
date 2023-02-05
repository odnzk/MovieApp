package com.study.favorite

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.study.common.State
import com.study.domain.usecase.FavoriteMoviesUsecases
import com.study.favorite.mapper.toUiMovies
import com.study.favorite.model.UiMovie
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.flow.distinctUntilChanged
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class FavoriteMoviesViewModel @Inject constructor(
    private val favoriteMoviesUsecases: FavoriteMoviesUsecases
) : ViewModel() {

    private var _movies: MutableStateFlow<State<List<UiMovie>>> =
        MutableStateFlow(State.Loading())
    val movies = _movies.asStateFlow()

    init {
        loadData()
    }

    private fun loadData() = viewModelScope.launch {
        favoriteMoviesUsecases.getAllFavoriteMovies().distinctUntilChanged()
            .collectLatest { repoMovies ->
                _movies.value = State.Success(repoMovies.toUiMovies())
            }
    }

    fun onEvent(event: FavoriteMoviesEvent) = viewModelScope.launch {
        when (event) {
            FavoriteMoviesEvent.TryAgain -> loadData()
            is FavoriteMoviesEvent.RemoveFromFavorite -> favoriteMoviesUsecases.deleteFavoriteMovies(
                event.movie
            )
        }
    }
}
