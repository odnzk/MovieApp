package com.study.presentation

sealed interface FavoriteMoviesEvent {
    object TryAgain : FavoriteMoviesEvent
}
