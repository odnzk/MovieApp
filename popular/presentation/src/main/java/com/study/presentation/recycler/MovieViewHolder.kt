package com.study.presentation.recycler

import androidx.recyclerview.widget.RecyclerView
import com.study.domain.model.Movie
import com.study.presentation.databinding.ItemMovieBinding
import com.study.ui.loadImage

class MovieViewHolder(
    private val binding: ItemMovieBinding,
    private val onMovieClick: ((Int) -> Unit)? = null
) :
    RecyclerView.ViewHolder(binding.root) {

    fun bind(movie: Movie) {
        with(binding) {
            tvTitle.text = movie.title
            tvDescription.text = movie.description
            ivFavorite.loadImage(movie.imageUrl)

            onMovieClick?.let { onMovieClick ->
                root.setOnClickListener { onMovieClick(movie.id) }
            }
        }
    }
}
