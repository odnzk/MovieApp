package com.study.domain.model

data class DetailedMovie(
    val id: Int,
    val title: String,
    val description: String,
    val imageUrl: String,
    val genres: List<String>,
    val countries: List<String>
)
