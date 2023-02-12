package com.study.domain.usecase

import com.study.domain.model.movie.Movie
import com.study.domain.repository.FavoriteMovieRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import java.net.URL

class AddToFavoriteMovies(private val repository: FavoriteMovieRepository) {

    suspend operator fun invoke(vararg movie: Movie) = withContext(Dispatchers.IO) {
        // the image(blob) must be stored in the database so that it can be downloaded offline later,
        // so when adding it to the database, we convert the imageUrl into bytes
        movie.map { movie ->
            movie.imageBytes = URL(movie.imageUrl).readBytes()
        }
        repository.add(*movie)
    }
}
