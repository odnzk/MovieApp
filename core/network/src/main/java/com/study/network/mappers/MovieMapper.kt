package com.study.network.mappers

import com.study.domain.model.DetailedMovie
import com.study.domain.model.Movie
import com.study.network.model.MovieDetailedDto
import com.study.network.model.MovieDto

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
