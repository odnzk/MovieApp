package com.study.presentation.mapper

import android.graphics.Bitmap
import android.graphics.BitmapFactory
import com.study.domain.model.Movie
import com.study.presentation.model.UiMovie
import java.io.ByteArrayOutputStream

internal fun List<Movie>.toUiMovies(): List<UiMovie> = map { it.toUiMovie() }
internal fun List<UiMovie>.toMovies(): List<Movie> = map { it.toMovie() }

internal fun Movie.toUiMovie(): UiMovie {
    val bitmap: Bitmap? =
        imageBytes?.let { BitmapFactory.decodeByteArray(it, 0, it.size) }
    return UiMovie(
        id = id, title = title, genre = genre, year = year,
        imageBitmap = bitmap
    )
}

internal fun UiMovie.toMovie(): Movie {
    val stream = ByteArrayOutputStream()
    imageBitmap?.compress(Bitmap.CompressFormat.PNG, 90, stream)
    val image = stream.toByteArray()
    return Movie(
        id = id, title = title, genre = genre, year = year,
        imageUrl = null, imageBytes = image
    )
}
