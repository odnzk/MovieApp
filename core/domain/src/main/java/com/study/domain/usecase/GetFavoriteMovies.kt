package com.study.domain.usecase

import com.study.domain.model.Movie
import com.study.domain.repository.FavoriteMovieRepository
import com.study.domain.repository.MovieRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.map
import retrofit2.HttpException
import java.io.IOException

class GetFavoriteMovies(
    private val remoteRepository: MovieRepository,
    private val localRepository: FavoriteMovieRepository
) {
    suspend operator fun invoke(): Flow<List<Movie>> =
        localRepository.getAllId().map { favoriteIds ->
            try {
                // because there are a hundred popular movies I get all top movies and then here filter
                // instead of requesting each movie by ID
                val movies = remoteRepository.getTopMovies()
                val favoriteMovies = movies.filter { movie -> movie.id in favoriteIds }

                // to update favorite movies while user have an internet connection
                localRepository.update(*favoriteMovies.toTypedArray())

                return@map favoriteMovies
            } catch (e: HttpException) {
                return@map localRepository.getAll().first()
            } catch (e: IOException) {
                return@map localRepository.getAll().first()
            }
        }

}
