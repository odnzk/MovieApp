package com.study.ui

import android.widget.ImageView
import coil.load
import coil.request.CachePolicy
import coil.request.ErrorResult
import coil.request.ImageRequest
import coil.size.Scale

fun ImageView.loadImage(url: String, onError: ((ImageRequest, ErrorResult) -> Unit)? = null) {
    load(url) {
        placeholder(R.drawable.ic_loading)
        transformations()
        scale(Scale.FILL)
        diskCachePolicy(CachePolicy.ENABLED)
        memoryCachePolicy(CachePolicy.ENABLED)
        listener(
            onError = { imageRequest, errorResult ->
                onError?.invoke(imageRequest, errorResult)
            }
        )
    }
}
