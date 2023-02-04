package com.study.data.mappers

import com.study.data.model.MovieDto
import com.study.domain.model.Movie

fun MovieDto.toMovie(): Movie = Movie(
    id = kinopoiskId,
    title = nameRu,
    genres = genres.map { it.genre },
    year = year,
    description = description,
    imageUrl = posterUrl,
    countries = countries.map { it.country }
)

fun List<MovieDto>.toMovies(): List<Movie> = map { it.toMovie() }
