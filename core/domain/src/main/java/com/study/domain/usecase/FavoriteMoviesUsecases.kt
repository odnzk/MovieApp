package com.study.domain.usecase

class FavoriteMoviesUsecases(
    val getAllFavoriteMovies: GetFavoriteMovies,
    val addToFavoriteMovies: AddToFavoriteMovies,
    val deleteFavoriteMovies: DeleteFavoriteMovies,
    val updateFavoriteMovies: UpdateFavoriteMovies,
    val getFavoriteMoviesIds: GetFavoriteMoviesIds
)
