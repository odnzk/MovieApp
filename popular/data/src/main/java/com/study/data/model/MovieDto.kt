package com.study.data.model

data class MovieDto(
    val countries: List<CountryDto>,
    val filmId: Int, // 4370148
    val filmLength: String, // 01:53
    val genres: List<GenreDto>,
    val nameEn: Any, // null
    val nameRu: String, // Чебурашка
    val posterUrl: String, // https://kinopoiskapiunofficial.tech/images/posters/kp/4370148.jpg
    val posterUrlPreview: String, // https://kinopoiskapiunofficial.tech/images/posters/kp_small/4370148.jpg
    val rating: String, // 8.0
    val ratingChange: Any, // null
    val ratingVoteCount: Int, // 22901
    val year: String // 2022
)
