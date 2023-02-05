package com.study.presentation.util.mapper

import com.study.domain.model.Movie
import com.study.presentation.model.UiMovie

internal fun Movie.toUiMovie(isFavorite: Boolean): UiMovie =
    UiMovie(id, title, genre, year, imageUrl, isFavorite = isFavorite)

internal fun UiMovie.toMovie(): Movie = Movie(id, title, genre, year, imageUrl)

internal fun List<UiMovie>.toMovies(): List<Movie> = map { it.toMovie() }

internal fun List<Movie>.toUiMovies(favoriteMoviesId: Set<Int>): List<UiMovie> = map { movie ->
    movie.toUiMovie(movie.id in favoriteMoviesId)
}
