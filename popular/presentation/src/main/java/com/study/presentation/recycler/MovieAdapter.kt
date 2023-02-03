package com.study.presentation.recycler

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import com.bumptech.glide.RequestManager
import com.study.domain.Movie
import com.study.presentation.databinding.ItemMovieBinding

class MovieAdapter : ListAdapter<Movie, MovieViewHolder>(MovieItemCallback()) {
    var glide: RequestManager? = null
    var onMovieClick: ((Long) -> Unit)? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieViewHolder {
        return MovieViewHolder(
            glide = glide,
            binding = ItemMovieBinding.inflate(LayoutInflater.from(parent.context), parent, false),
            onMovieClick = onMovieClick
        )
    }

    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

}