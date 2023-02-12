package com.study.domain.model.pagination

data class Pagination(val currentPage: Int, val pagesCount: Int) {
    companion object {
        const val UNKNOWN_PAGES_COUNT = -1
        const val DEFAULT_PAGE_SIZE = 1 // todo
    }

    val canLoadMore: Boolean
        get() = pagesCount == UNKNOWN_PAGES_COUNT || currentPage < pagesCount
}
