package com.study.movieapp.di.modules

import com.study.domain.repository.FavoriteMovieRepository
import com.study.domain.repository.MovieRepository
import com.study.domain.usecase.*
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object UsecaseModule {

    @Provides
    fun providesMovieUseCases(movieRepository: MovieRepository): MovieUsecases = MovieUsecases(
        getMovieById = GetMovieById(movieRepository),
        getTopMovies = GetTopMovies(movieRepository)
    )

    @Provides
    fun providesFavoriteMovieUseCases(movieRepository: FavoriteMovieRepository): FavoriteMoviesUsecases =
        FavoriteMoviesUsecases(
            addToFavoriteMovies = AddToFavoriteMovies(movieRepository),
            updateFavoriteMovies = UpdateFavoriteMovies(movieRepository),
            deleteFavoriteMovies = DeleteFavoriteMovies(movieRepository),
            getAllFavoriteMovies = GetAllFavoriteMovies(movieRepository),
            getFavoriteMoviesIds = GetFavoriteMoviesIds(movieRepository)
        )

}
