package com.study.ui

import androidx.core.view.isVisible
import com.study.domain.exceptions.ConnectionLostException
import com.study.domain.exceptions.InvalidMovieIdException
import com.study.domain.exceptions.NetworkException
import com.study.ui.databinding.StateLoadingBinding

fun StateLoadingBinding.loadingFinished() {
    progressBar.hide()
    ivError.isVisible = false
    tvError.isVisible = false
    btnTryAgain.isVisible = false
}

fun StateLoadingBinding.loadingStarted() {
    progressBar.show()
    ivError.isVisible = false
    tvError.isVisible = false
    btnTryAgain.isVisible = false
}

fun StateLoadingBinding.errorOccurred(error: Throwable, tryAgainAction: () -> Unit) {
    val message = when (error) {
        is ConnectionLostException -> {
            ivError.setImageResource(R.drawable.ic_connection_lost)
            ivError.isVisible = true
            root.context.getString(R.string.error_connection_lost)
        }
        is NetworkException -> {
            ivError.setImageResource(R.drawable.ic_connection_lost)
            ivError.isVisible = true
            root.context.getString(R.string.error_network, error.code)
        }
        is InvalidMovieIdException -> root.context.getString(R.string.error_movie_id)
        else -> root.context.getString(R.string.error_unknown)
    }
    tvError.text = message
    btnTryAgain.setOnClickListener { tryAgainAction() }
    progressBar.hide()
    tvError.isVisible = true
    btnTryAgain.isVisible = true
}
