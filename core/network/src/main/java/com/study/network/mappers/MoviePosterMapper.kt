package com.study.network.mappers

import com.study.domain.model.movie.details.MoviePoster
import com.study.network.model.MovieDetailedDto
import com.study.network.model.MovieDto

internal fun MovieDto.toMoviePoster(): MoviePoster {
    return MoviePoster(
        smallPosterUrl = posterUrlPreview.orEmpty(),
        fullPosterUrl = posterUrl.orEmpty()
    )
}

internal fun MovieDetailedDto.toMoviePoster(): MoviePoster {
    return MoviePoster(
        smallPosterUrl = posterUrlPreview.orEmpty(),
        fullPosterUrl = posterUrl.orEmpty()
    )
}
