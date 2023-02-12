package com.study.presentation.screens.detailed_movie

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.study.common.State
import com.study.domain.exceptions.InvalidMovieIdException
import com.study.domain.model.movie.DetailedMovie
import com.study.domain.usecase.MovieUsecases
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
internal class DetailedMovieViewModel @Inject constructor(
    private val movieUsecases: MovieUsecases,
    savedStateHandle: SavedStateHandle
) :
    ViewModel() {

    private val movieId: Int? = savedStateHandle.get<Int>("movieId").takeIf { id -> id != -1 }

    private var _movie: MutableStateFlow<State<DetailedMovie>> =
        MutableStateFlow(State.Loading())
    val movie = _movie.asStateFlow()

    init {
        loadData()
    }

    private fun loadData() = viewModelScope.launch {
        movieId?.let {
            movieUsecases.getMovieById(movieId).collectLatest { repoMovie ->
                _movie.value = repoMovie
            }
        } ?: run {
            _movie.value = State.Error(InvalidMovieIdException())
        }
    }

    fun onEvent(event: DetailedMovieEvent) = viewModelScope.launch {
        when (event) {
            DetailedMovieEvent.TryAgain -> loadData()
        }
    }

}
