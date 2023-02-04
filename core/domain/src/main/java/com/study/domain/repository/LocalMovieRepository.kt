package com.study.domain.repository

import kotlinx.coroutines.flow.Flow

interface LocalMovieRepository {
    suspend fun add(vararg movie: Movie)
    suspend fun delete(vararg movie: Movie)
    suspend fun update(vararg movie: Movie)
    fun getAll(): Flow<List<Movie>>
}
