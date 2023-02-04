package com.study.domain.usecase

import com.study.domain.model.Movie
import com.study.domain.repository.FavoriteMovieRepository
import kotlinx.coroutines.flow.Flow

class GetAllFavoriteMovies(private val repository: FavoriteMovieRepository) {

    operator fun invoke(): Flow<List<Movie>> = repository.getAll()
}
