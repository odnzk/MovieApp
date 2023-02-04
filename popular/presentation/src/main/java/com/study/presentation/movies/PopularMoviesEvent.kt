package com.study.presentation.movies

sealed interface PopularMoviesEvent {
    object TryAgain : PopularMoviesEvent
}
