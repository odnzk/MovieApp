package com.study.favorite

import com.study.domain.model.Movie

internal sealed interface FavoriteMoviesEvent {
    object TryAgain : FavoriteMoviesEvent
    data class RemoveFromFavorite(val movie: Movie) : FavoriteMoviesEvent
}
