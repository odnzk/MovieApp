package com.study.ui

import com.study.domain.model.Movie
import com.study.ui.databinding.StateNotFoundBinding

interface SearchFragment {
    fun onSearchQueryChanged(query: String?)
}

// extension to prohibit this function from being performed
// by a fragment unrelated to the search in any way
// todo
fun SearchFragment.searchMovies(
    query: String?,
    notFoundBinding: StateNotFoundBinding? = null,
    movies: List<Movie>,
    onResult: (List<Movie>) -> Unit,
) {
    val filtered = query?.let {
        movies.filter { movie ->
            movie.title.lowercase().contains(query.lowercase())
        }
    } ?: movies
    if (filtered.isEmpty()) {
        notFoundBinding?.show()
    } else {
        notFoundBinding?.hide()
    }
    onResult(filtered)
}
