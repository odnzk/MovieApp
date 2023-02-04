package com.study.movieapp.di.modules

import com.study.domain.repository.MovieRepository
import com.study.domain.usecase.GetMovieById
import com.study.domain.usecase.GetTopMovies
import com.study.domain.usecase.MovieUsecases
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
}
