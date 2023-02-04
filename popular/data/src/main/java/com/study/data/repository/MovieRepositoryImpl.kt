package com.study.data.repository

import com.study.data.api.MoviesApi
import com.study.data.mappers.toMovie
import com.study.data.mappers.toMovies
import com.study.domain.model.Movie
import com.study.domain.repository.MovieRepository
import javax.inject.Inject

class MovieRepositoryImpl @Inject constructor(
    private val api: MoviesApi
) : MovieRepository {

    override suspend fun getTopMovies(): List<Movie> {
        return api.getTopMovies().films.toMovies()
    }

    override suspend fun getMovieById(id: Int): Movie {
        return api.getMovieById(id).toMovie()
    }
}
