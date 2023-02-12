package com.study.domain.repository

import com.study.domain.model.movie.DetailedMovie
import com.study.domain.model.pagination.PaginatedMovies

interface MovieRepository {
    suspend fun getTopMovies(): PaginatedMovies
    suspend fun getMovieById(id: Int): DetailedMovie
}
