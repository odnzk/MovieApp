package com.study.data.api

import com.study.data.model.MovieDetailedDto
import com.study.data.model.MoviesListDto
import retrofit2.http.GET
import retrofit2.http.Path

interface MoviesApi {

    @GET("/api/v2.2/films/{movieId}")
    suspend fun getMovieById(@Path("movieId") id: Int): MovieDetailedDto

    @GET("/api/v2.2/films/top?type=TOP_100_POPULAR_FILMS")
    suspend fun getTopMovies(): MoviesListDto

}
