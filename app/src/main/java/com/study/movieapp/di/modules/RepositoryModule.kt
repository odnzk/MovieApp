package com.study.movieapp.di.modules

import com.study.data.repository.MovieRepositoryImpl
import com.study.database.repository.FavoriteMovieRepositoryImpl
import com.study.domain.repository.FavoriteMovieRepository
import com.study.domain.repository.MovieRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {

    @Binds
    abstract fun bindMovieRepository(movieRepositoryImpl: MovieRepositoryImpl): MovieRepository

    @Binds
    abstract fun bindFavoriteMovieRepository(movieRepositoryImpl: FavoriteMovieRepositoryImpl): FavoriteMovieRepository

}
