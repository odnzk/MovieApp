package com.study.presentation.navigation

import androidx.navigation.NavController
import com.study.presentation.screens.movies.PopularMoviesFragmentDirections

internal fun NavController.fromMoviesToDetailedMovie(movieId: Int) {
    val destination =
        PopularMoviesFragmentDirections.actionPopularMoviesFragmentToDetailedMovieFragment(movieId)
    navigate(destination)
}
