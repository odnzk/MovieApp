package com.study.domain.usecase

import com.study.domain.model.movie.Movie
import com.study.domain.repository.FavoriteMovieRepository

class DeleteFavoriteMovies(private val repository: FavoriteMovieRepository) {

    suspend operator fun invoke(vararg movie: Movie) = repository.delete(*movie)
}
