package com.study.network.repository


import com.study.domain.model.movie.DetailedMovie
import com.study.domain.model.pagination.PaginatedMovies
import com.study.domain.model.pagination.Pagination
import com.study.domain.repository.MovieRepository
import com.study.network.api.MoviesApi
import com.study.network.mappers.toDetailedMovie
import com.study.network.mappers.toMovies
import javax.inject.Inject

class MovieRepositoryImpl @Inject constructor(
    private val api: MoviesApi
) : MovieRepository {
    override suspend fun getTopMovies(): PaginatedMovies {
        return PaginatedMovies(
            movies = api.getTopMovies().films.toMovies(),
            pagination = Pagination(currentPage = 0, pagesCount = 0) // todo
        )
    }

//    override suspend fun getTopMovies(): List<Movie> {
//        return api.getTopMovies().films.toMovies()
//    }

    override suspend fun getMovieById(id: Int): DetailedMovie {
        return api.getMovieById(id).toDetailedMovie()
    }
}
