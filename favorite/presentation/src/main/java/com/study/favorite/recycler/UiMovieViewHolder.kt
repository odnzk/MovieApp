package com.study.favorite.recycler

import androidx.core.view.isVisible
import androidx.recyclerview.widget.RecyclerView
import com.study.favorite.model.UiMovie
import com.study.ui.databinding.ItemMovieBinding
import com.study.ui.loadImage

internal class UiMovieViewHolder(
    private val binding: ItemMovieBinding
) :
    RecyclerView.ViewHolder(binding.root) {

    fun bind(movie: UiMovie) {
        with(binding) {
            tvTitle.text = movie.title
            val genres: String = movie.genre
            tvDescription.text = root.context.getString(
                com.study.ui.R.string.rv_genre_with_year,
                genres,
                movie.year
            )
            ivFavorite.isVisible = true

            ivMovieImage.loadImage(movie.imageUrl,
                onError = { _, _ ->
                    pbForMovieImage.isVisible = false
                    ivMovieImage.setImageBitmap(movie.imageBitmap)
                },
                onSuccess = { _, _ ->
                    pbForMovieImage.isVisible = false
                }
            )
        }
    }

}
