package com.study.domain.usecase

import com.study.domain.model.Movie
import com.study.domain.repository.FavoriteMovieRepository

class UpdateFavoriteMovies(private val repository: FavoriteMovieRepository) {

    suspend operator fun invoke(vararg movie: Movie) = repository.update(*movie)
}
