package com.study.presentation.recycler

import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.RequestManager
import com.study.domain.Movie
import com.study.presentation.databinding.ItemMovieBinding
import com.study.presentation.util.loadWithLoadingState

class MovieViewHolder(
    private val binding: ItemMovieBinding,
    private val glide: RequestManager? = null,
    private val onMovieClick: ((Long) -> Unit)? = null
) :
    RecyclerView.ViewHolder(binding.root) {

    fun bind(movie: Movie) {
        with(binding) {
            tvTitle.text = movie.title
            tvDescription.text = movie.description
            glide?.loadWithLoadingState(movie.imageUrl, ivMovieImage)

            onMovieClick?.let { onMovieClick ->
                root.setOnClickListener { onMovieClick(movie.id) }
            }
        }
    }
}
