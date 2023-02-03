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

class GetMovieById(private val repository: MovieRepository) {

    suspend operator fun invoke(id: Int): Flow<Resource<Movie>> = flow {
        try {
            emit(Resource.Loading())
            val movie = repository.getMovieById(id)
            emit(Resource.Success(movie))
        } catch (e: HttpException) {
            emit(Resource.Error(NetworkException(code = e.code())))
        } catch (e: IOException) {
            emit(Resource.Error(ConnectionLostException()))
        }
    }

}
