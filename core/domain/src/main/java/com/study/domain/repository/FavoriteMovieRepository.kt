package com.study.domain.repository

import com.study.domain.model.movie.Movie
import kotlinx.coroutines.flow.Flow

interface FavoriteMovieRepository {
    suspend fun add(vararg movie: Movie)
    suspend fun delete(vararg movie: Movie)
    suspend fun update(vararg movie: Movie)
    fun getAll(): Flow<List<Movie>>
    fun getIdsOfAll(): Flow<List<Int>>
}
