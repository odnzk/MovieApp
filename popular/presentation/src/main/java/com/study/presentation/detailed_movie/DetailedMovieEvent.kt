package com.study.presentation.detailed_movie

internal sealed interface DetailedMovieEvent {
    object TryAgain : DetailedMovieEvent
}
