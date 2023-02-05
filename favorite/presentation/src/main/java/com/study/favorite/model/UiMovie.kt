package com.study.favorite.model

import android.graphics.Bitmap

data class UiMovie(
    val id: Int,
    val title: String,
    val genre: String,
    val year: Int?,
    val imageUrl: String,
    val imageBitmap: Bitmap?
)


