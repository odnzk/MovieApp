package com.study.ui

import androidx.core.view.isVisible
import com.study.ui.databinding.StateNotFoundBinding

fun StateNotFoundBinding.show() {
    btnNotFound.isVisible = true
}

fun StateNotFoundBinding.hide() {
    btnNotFound.isVisible = false
}
