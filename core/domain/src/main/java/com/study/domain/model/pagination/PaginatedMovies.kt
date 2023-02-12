package com.study.domain.model.pagination

import com.study.domain.model.movie.Movie

data class PaginatedMovies(
    val movies: List<Movie>,
    val pagination: Pagination
)
