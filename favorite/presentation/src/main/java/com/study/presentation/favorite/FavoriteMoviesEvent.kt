package com.study.presentation.favorite

sealed interface FavoriteMoviesEvent {
    object TryAgain : FavoriteMoviesEvent
}
