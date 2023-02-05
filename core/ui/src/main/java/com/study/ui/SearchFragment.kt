package com.study.ui

interface SearchFragment<T> {
    fun onSearchQueryChanged(query: String?)
    fun search(query: String?, data: List<T>)
}
