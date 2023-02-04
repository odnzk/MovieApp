package com.study.domain.usecase

class FavoriteMoviesUsecases(
    val getAllFavoriteMovies: GetAllFavoriteMovies,
    val addToFavoriteMovies: AddToFavoriteMovies,
    val deleteFavoriteMovies: DeleteFavoriteMovies,
    val updateFavoriteMovies: UpdateFavoriteMovies
)
