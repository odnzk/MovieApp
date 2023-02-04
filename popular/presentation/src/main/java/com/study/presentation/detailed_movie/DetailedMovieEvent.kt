package com.study.presentation.detailed_movie

sealed interface DetailedMovieEvent {
    object TryAgain : DetailedMovieEvent
}
