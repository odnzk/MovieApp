package com.study.domain.model

data class Movie(
    val id: Int,
    val title: String,
    val genres: List<String>,
    val year: Int?,
    val description: String? = null,
    val imageUrl: String,
    val countries: List<String>
)
