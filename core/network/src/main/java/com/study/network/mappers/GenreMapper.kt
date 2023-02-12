package com.study.network.mappers

import com.study.network.utils.capitalizeOrEmpty
import com.study.network.model.GenreDto

internal fun GenreDto.toGenreString(): String {
    return genre.capitalizeOrEmpty()
}

internal fun List<GenreDto>?.toGenreStrings(): List<String> {
    return this?.map { it.toGenreString() } ?: emptyList()
}
