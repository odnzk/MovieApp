package com.study.network.mappers

import com.study.domain.model.movie.DetailedMovie
import com.study.domain.model.movie.Movie
import com.study.domain.model.movie.details.MovieDetails
import com.study.domain.model.movie.values.Id
import com.study.network.model.MovieDetailedDto
import com.study.network.model.MovieDto
import com.study.network.utils.capitalizeOrEmpty

// todo handle invalid id exception
internal fun MovieDto.toMovie(): Movie? {
    val id = filmId?.let { Id.of(it) }
    return if (id?.isSuccess == true) {
        Movie(
            id = id.getOrThrow(),
            title = nameRu.capitalizeOrEmpty(),
            genres = genres.toGenreStrings(),
            year = year ?: UNKNOWN_VALUE,
            moviePoster = toMoviePoster()
        )
    } else null
}

// todo handle invalid id exception
internal fun MovieDetailedDto.toDetailedMovie(): DetailedMovie? {
    val id = kinopoiskId?.let { Id.of(it) }
    return if (id?.isSuccess == true) {
        DetailedMovie(
            id = id.getOrThrow(),
            title = nameRu?.capitalizeOrEmpty().orEmpty(),
            genres = genres.toGenreStrings(),
            year = year ?: UNKNOWN_VALUE,
            moviePoster = toMoviePoster(),
            movieDetails = MovieDetails(
                description = description.capitalizeOrEmpty(),
                countries = countries.toCountryStrings()
            )
        )
    } else null
}


internal fun List<MovieDto>?.toMovies(): List<Movie> =
    this?.mapNotNull { it.toMovie() } ?: emptyList()

private const val UNKNOWN_VALUE = -1
