package com.study.domain.repository

import com.study.domain.model.Movie
import kotlinx.coroutines.flow.Flow

interface MovieRepository {
    fun getTopMovies(): Flow<List<Movie>>

    suspend fun getMovieById(id: Int): Movie
}
