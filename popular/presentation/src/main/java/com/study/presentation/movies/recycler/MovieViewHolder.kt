package com.study.presentation.movies.recycler

import androidx.recyclerview.widget.RecyclerView
import com.study.common.Movie
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
            val genres: String = movie.genre
            tvDescription.text = root.context.getString(
                com.study.ui.R.string.rv_genre_with_year,
                genres,
                movie.year
            )
            movie.imageUrl?.let { ivMovieImage.loadImage(it) }
            onMovieClick?.let { onMovieClick ->
                root.setOnClickListener { onMovieClick(movie.id) }
            }
        }
    }
}
