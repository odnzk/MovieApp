package com.study.database.mapper


import com.study.database.entity.MovieEntity
import com.study.domain.model.movie.Movie

internal fun MovieEntity.toMovie(): Movie {
    return Movie(
        id = id,
        title = title,
        genre = genre,
        year = year,
        imageUrl = imageUrl,
        imageBytes = imageBytes
    )
}

internal fun Movie.toEntity(): MovieEntity = MovieEntity(
    id = id, imageBytes = imageBytes, title = title, genre = genre, year = year, imageUrl = imageUrl
)


internal fun Array<out Movie>.toEntities(): Array<MovieEntity> =
    map { it.toEntity() }.toTypedArray()

internal fun List<MovieEntity>.toMovies() = map { it.toMovie() }
