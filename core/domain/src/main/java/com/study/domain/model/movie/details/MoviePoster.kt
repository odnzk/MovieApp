package com.study.domain.model.movie.details

data class MoviePoster(
    val smallPosterUrl: String, val fullPosterUrl: String
) {
    fun getSmallestPoster(): String {
        return if (isUrlValid(smallPosterUrl)) smallPosterUrl
        else if (isUrlValid(fullPosterUrl)) fullPosterUrl
        else NO_POSTER_URL
    }

    private fun isUrlValid(url: String) = url.isNotBlank()

    companion object {
        // todo maybe change to some exception
        private const val NO_POSTER_URL = ""
    }
}
