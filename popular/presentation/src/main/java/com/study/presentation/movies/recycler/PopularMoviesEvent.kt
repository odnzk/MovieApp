package com.study.presentation.movies.recycler

sealed interface PopularMoviesEvent {
    object TryAgain : PopularMoviesEvent
}
