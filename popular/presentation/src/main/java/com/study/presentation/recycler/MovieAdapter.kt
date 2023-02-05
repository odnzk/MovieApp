package com.study.presentation.recycler

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import com.study.domain.model.Movie
import com.study.presentation.model.UiMovie
import com.study.ui.databinding.ItemMovieBinding

internal class MovieAdapter : ListAdapter<UiMovie, MovieViewHolder>(MovieItemCallback()) {
    var onMovieClick: ((Int) -> Unit)? = null
    var onLongClick: ((Movie) -> Unit)? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieViewHolder {
        return MovieViewHolder(
            binding = ItemMovieBinding.inflate(LayoutInflater.from(parent.context), parent, false),
            onMovieClick = onMovieClick,
            onLongClick = onLongClick
        )
    }

    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

}
