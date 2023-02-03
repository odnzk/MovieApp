package com.study.data.repository

import com.study.data.api.MoviesApi
import com.study.data.mappers.toMovie
import com.study.data.mappers.toMovies
import com.study.domain.model.Movie
import com.study.domain.repository.MovieRepository

class MovieRepositoryImpl(
    private val api: MoviesApi
) : MovieRepository {

    override suspend fun getTopMovies(): List<Movie> {
        return api.getTopMovies().toMovies()
    }

    override suspend fun getMovieById(id: Int): Movie {
        return api.getMovieById(id).toMovie()
    }
}
