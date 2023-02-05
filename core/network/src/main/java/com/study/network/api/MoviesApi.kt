package com.study.network.api

import com.study.network.model.MovieDetailedDto
import com.study.network.model.MoviesListDto
import retrofit2.http.GET
import retrofit2.http.Path

interface MoviesApi {

    @GET("/api/v2.2/films/{movieId}")
    suspend fun getMovieById(@Path("movieId") id: Int): MovieDetailedDto

    @GET("/api/v2.2/films/top?type=TOP_100_POPULAR_FILMS")
    suspend fun getTopMovies(): MoviesListDto

}
