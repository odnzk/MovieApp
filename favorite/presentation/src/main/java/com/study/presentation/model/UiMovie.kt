package com.study.presentation.model

import android.graphics.Bitmap

data class UiMovie(
    val id: Int,
    val title: String,
    val genre: String,
    val year: Int?,
    val imageBitmap: Bitmap?
)
