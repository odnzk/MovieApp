package com.study.domain.usecase

import com.study.domain.model.Movie
import com.study.domain.repository.MovieRepository

class GetMovieById(private val movieRepository: MovieRepository) {

    suspend operator fun invoke(id: Int): Movie {
        return movieRepository.getMovieById(id)
    }
}
