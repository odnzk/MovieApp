package com.study.data.repository

import com.study.data.api.MoviesApi
import com.study.data.mappers.toMovie
import com.study.data.mappers.toMovies
import com.study.domain.model.Movie
import com.study.domain.repository.MovieRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class MovieRepositoryImpl(private val api: MoviesApi) : MovieRepository {
    override fun getTopMovies(): Flow<List<Movie>> {
        return api.getTopMovies().map { dtoMovies -> dtoMovies.toMovies() }
    }

    override suspend fun getMovieById(id: Int): Movie {
        return api.getMovieById(id).toMovie()
    }
}
