package com.study.presentation.util.recycler

import androidx.recyclerview.widget.DiffUtil.ItemCallback
import com.study.presentation.model.UiMovie

internal class MovieItemCallback : ItemCallback<UiMovie>() {

    override fun areItemsTheSame(oldItem: UiMovie, newItem: UiMovie): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: UiMovie, newItem: UiMovie): Boolean {
        return oldItem.title == newItem.title
                && oldItem.genre == newItem.genre
                && oldItem.year == newItem.year
                && oldItem.imageUrl == newItem.imageUrl && oldItem.isFavorite == newItem.isFavorite

    }
}
