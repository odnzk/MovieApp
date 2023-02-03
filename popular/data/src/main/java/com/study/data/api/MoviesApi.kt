package com.study.data.api

import com.study.data.model.MovieDto
import retrofit2.http.GET
import retrofit2.http.Path

interface MoviesApi {

    @GET("/api/v2.2/films/top/{movieId}")
    suspend fun getMovieById(@Path("movieId") id: Int): MovieDto

    @GET("/api/v2.2/films/top?type=TOP_100_POPULAR_FILMS")
    fun getTopMovies(): List<MovieDto>
}
