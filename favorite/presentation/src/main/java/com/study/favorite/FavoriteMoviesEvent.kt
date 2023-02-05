package com.study.favorite

import com.study.domain.model.Movie

sealed interface FavoriteMoviesEvent {
    object TryAgain : FavoriteMoviesEvent
    data class RemoveFromFavorite(val movie: Movie) : FavoriteMoviesEvent
}
