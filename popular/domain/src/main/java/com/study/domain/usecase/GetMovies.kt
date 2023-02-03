package com.study.domain.usecase

import com.study.domain.model.Movie
import com.study.domain.repository.MovieRepository
import kotlinx.coroutines.flow.Flow

class GetMovies(private val movieRepository: MovieRepository) {

    operator fun invoke(): Flow<List<Movie>>{
        return movieRepository.getMovies()
    }
}
