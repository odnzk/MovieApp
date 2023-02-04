package com.study.data.mappers

import com.study.data.model.MovieDto
import com.study.domain.model.Movie

fun MovieDto.toMovie(): Movie = Movie(
    id = filmId,
    title = nameRu.replaceFirstChar { char -> char.uppercaseChar() },
    genre = genres[0].genre.replaceFirstChar { char -> char.uppercaseChar() },
    year = year.toIntOrNull(),
    imageUrl = posterUrlPreview
)

fun List<MovieDto>.toMovies(): List<Movie> = map { it.toMovie() }
