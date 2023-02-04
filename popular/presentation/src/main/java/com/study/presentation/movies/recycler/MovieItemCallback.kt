package com.study.presentation.movies.recycler

import androidx.recyclerview.widget.DiffUtil.ItemCallback
import com.study.domain.model.Movie

class MovieItemCallback : ItemCallback<Movie>() {
    override fun areItemsTheSame(oldItem: Movie, newItem: Movie): Boolean = oldItem.id == newItem.id

    override fun areContentsTheSame(oldItem: Movie, newItem: Movie): Boolean =
        oldItem.title == newItem.title
                && oldItem.genre == newItem.genre
                && oldItem.year == newItem.year
                && oldItem.imageUrl == newItem.imageUrl
}
