package com.study.favorite.recycler

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import com.study.favorite.model.UiMovie
import com.study.ui.databinding.ItemMovieBinding

class UiMovieAdapter : ListAdapter<UiMovie, UiMovieViewHolder>(UiMovieItemCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UiMovieViewHolder {
        return UiMovieViewHolder(
            binding = ItemMovieBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        )
    }

    override fun onBindViewHolder(holder: UiMovieViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

}
