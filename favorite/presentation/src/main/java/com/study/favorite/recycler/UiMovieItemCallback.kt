package com.study.favorite.recycler

import androidx.recyclerview.widget.DiffUtil.ItemCallback
import com.study.favorite.model.UiMovie

internal class UiMovieItemCallback : ItemCallback<UiMovie>() {

    override fun areItemsTheSame(oldItem: UiMovie, newItem: UiMovie): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: UiMovie, newItem: UiMovie): Boolean {
        return oldItem.title == newItem.title
                && oldItem.genre == newItem.genre
                && oldItem.year == newItem.year
                && oldItem.imageBitmap?.sameAs(newItem.imageBitmap) == true
    }
}
