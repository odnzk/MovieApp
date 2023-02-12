package com.study.domain.model.movie

import com.study.domain.model.movie.details.MoviePoster
import com.study.domain.model.movie.values.Id

data class Movie(
    val id: Id,
    val title: String,
    val genres: List<String>,
    val year: Int,
    val moviePoster: MoviePoster
)
