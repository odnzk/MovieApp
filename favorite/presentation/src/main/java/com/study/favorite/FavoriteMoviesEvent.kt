package com.study.favorite

sealed interface FavoriteMoviesEvent {
    object TryAgain : FavoriteMoviesEvent
}
