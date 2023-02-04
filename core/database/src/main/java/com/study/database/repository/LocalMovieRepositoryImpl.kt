package com.study.database.repository

import com.study.common.LocalMovieRepository
import com.study.common.Movie
import com.study.database.dao.MovieDao
import com.study.database.mapper.toEntities
import com.study.database.mapper.toMovies
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class LocalMovieRepositoryImpl @Inject constructor(private val dao: MovieDao) :
    LocalMovieRepository {
    override suspend fun add(vararg movie: Movie) {
        dao.insert(*movie.toEntities())
    }

    override suspend fun delete(vararg movie: Movie) {
        dao.delete(*movie.toEntities())
    }

    override suspend fun update(vararg movie: Movie) {
        dao.update(*movie.toEntities())
    }

    override fun getAll(): Flow<List<Movie>> {
        return dao.getAll().map { list -> list.toMovies() }
    }
}