package com.study.ui

import android.widget.ImageView
import coil.load
import coil.size.Scale

fun ImageView.loadImage(url: String) {
    load(url) {
        placeholder(R.drawable.ic_loading)
        transformations()
        scale(Scale.FILL)
    }
}
