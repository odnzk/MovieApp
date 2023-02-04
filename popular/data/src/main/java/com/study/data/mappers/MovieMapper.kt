package com.study.data.mappers

import com.study.common.Movie
import com.study.data.model.MovieDetailedDto
import com.study.data.model.MovieDto
import com.study.domain.model.DetailedMovie

fun MovieDto.toMovie(): Movie = Movie(
    id = filmId,
    title = nameRu.capitalize(),
    genre = genres[0].genre.capitalize(),
    year = year.toIntOrNull(),
    imageUrl = posterUrlPreview
)

fun List<MovieDto>.toMovies(): List<Movie> = map { it.toMovie() }

fun MovieDetailedDto.toDetailedMovie(): DetailedMovie =
    DetailedMovie(
        id = kinopoiskId,
        imageUrl = posterUrl,
        title = nameRu.capitalize(),
        genres = genres.map { it.genre },
        countries = countries.map { it.country.capitalize() },
        description = description.capitalize(),
    )

private fun String.capitalize() = replaceFirstChar { char -> char.uppercaseChar() }
