package com.study.domain.usecase

import com.study.common.State
import com.study.domain.exceptions.ConnectionLostException
import com.study.domain.exceptions.NetworkException
import com.study.domain.model.Movie
import com.study.domain.repository.MovieRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException

class GetTopMovies(
    private val repository: MovieRepository
) {

    operator fun invoke(): Flow<State<List<Movie>>> = flow {
        try {
            emit(State.Loading())
            val movies = repository.getTopMovies()
            emit(State.Success(movies))
        } catch (e: HttpException) {
            emit(State.Error(NetworkException(code = e.code())))
        } catch (e: IOException) {
            emit(State.Error(ConnectionLostException()))
        }
    }
}


