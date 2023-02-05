package com.study.presentation.screens.movies

import com.study.domain.model.Movie

internal sealed interface PopularMoviesEvent {
    object TryAgain : PopularMoviesEvent
    data class ToFavorite(val movie: Movie) : PopularMoviesEvent
}
