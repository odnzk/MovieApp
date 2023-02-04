package com.study.presentation.navigation

import androidx.navigation.NavController
import com.study.presentation.movies.PopularMoviesFragmentDirections

fun NavController.fromMoviesToDetailedMovie(movieId: Int) {
    val destination =
        PopularMoviesFragmentDirections.actionPopularMoviesFragmentToDetailedMovieFragment(movieId)
    navigate(destination)
}