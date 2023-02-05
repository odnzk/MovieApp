package com.study.presentation.screens.detailed_movie

internal sealed interface DetailedMovieEvent {
    object TryAgain : DetailedMovieEvent
}
