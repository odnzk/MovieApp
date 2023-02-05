package com.study.presentation.model

data class UiMovie(
    val id: Int,
    val title: String,
    val genre: String,
    val year: Int?,
    val imageUrl: String,
    val isFavorite: Boolean = false
)
