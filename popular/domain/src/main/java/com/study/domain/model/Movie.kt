package com.study.domain.model

data class Movie(
    val id: Int,
    val title: String,
    val genre: String,
    val year: Int?,
    val imageUrl: String
)
