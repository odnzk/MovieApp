package com.study.favorite.model

import android.graphics.Bitmap
import com.study.domain.model.Movie

class UiMovie(
    id: Int,
    title: String,
    genre: String,
    year: Int?,
    val imageBitmap: Bitmap?
) : Movie(id,title, genre, year, imageUrl = null)

