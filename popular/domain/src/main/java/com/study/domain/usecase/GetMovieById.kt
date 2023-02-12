package com.study.domain.usecase

import com.study.common.State
import com.study.domain.exceptions.ConnectionLostException
import com.study.domain.exceptions.NetworkException
import com.study.domain.model.movie.DetailedMovie
import com.study.domain.repository.MovieRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException

class GetMovieById(private val repository: MovieRepository) {

    suspend operator fun invoke(id: Int): Flow<State<DetailedMovie>> = flow {
        try {
            emit(State.Loading())
            val movie = repository.getMovieById(id)
            emit(State.Success(movie))
        } catch (e: HttpException) {
            emit(State.Error(NetworkException(code = e.code())))
        } catch (e: IOException) {
            emit(State.Error(ConnectionLostException()))
        }
    }

}
