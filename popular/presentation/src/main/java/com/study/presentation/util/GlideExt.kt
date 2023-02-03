package com.study.presentation.util

import android.widget.ImageView
import com.bumptech.glide.RequestManager
import com.study.ui.R

fun RequestManager.loadWithLoadingState(url: String, iv: ImageView) {
    load(url)
        .centerCrop()
        .placeholder(R.drawable.ic_loading)
        .into(iv)
}
