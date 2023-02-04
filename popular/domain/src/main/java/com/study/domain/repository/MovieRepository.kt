package com.study.domain.repository

import com.study.domain.model.DetailedMovie
import com.study.domain.model.Movie

interface MovieRepository {
    suspend fun getTopMovies(): List<Movie>

    suspend fun getMovieById(id: Int): DetailedMovie
}
