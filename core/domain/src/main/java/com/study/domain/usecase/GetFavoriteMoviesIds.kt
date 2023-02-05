package com.study.domain.usecase

import com.study.domain.repository.FavoriteMovieRepository
import kotlinx.coroutines.flow.Flow

class GetFavoriteMoviesIds(private val repository: FavoriteMovieRepository) {

    operator fun invoke(): Flow<List<Int>> = repository.getAllId()
}
