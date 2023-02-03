package com.study.domain.usecase

import com.study.common.Resource
import com.study.domain.exceptions.ConnectionLostException
import com.study.domain.exceptions.NetworkException
import com.study.domain.model.Movie
import com.study.domain.repository.MovieRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException

class GetTopMovies(private val repository: MovieRepository) {

    operator fun invoke(): Flow<Resource<List<Movie>>> = flow {
        try {
            emit(Resource.Loading())
            val movies = repository.getTopMovies()
            emit(Resource.Success(movies))
        } catch (e: HttpException) {
            emit(Resource.Error(NetworkException(code = e.code())))
        } catch (e: IOException) {
            emit(Resource.Error(ConnectionLostException()))
        }
    }
}


