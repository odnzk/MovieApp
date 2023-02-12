package com.study.domain.model.movie.values

import com.study.domain.exceptions.InvalidMovieIdException

@JvmInline
value class Id private constructor(val id: Int) {
    companion object {
        fun of(id: Int): Result<Id> {
            return if (id < 0) Result.failure(InvalidMovieIdException())
            else Result.success(Id(id))
        }
    }
}
