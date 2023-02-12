package com.study.network.mappers

import com.study.network.utils.capitalizeOrEmpty
import com.study.network.model.CountryDto

internal fun CountryDto.toCountryString(): String {
    return country.capitalizeOrEmpty()
}

internal fun List<CountryDto>?.toCountryStrings(): List<String> {
    return this?.map { it.toCountryString() } ?: emptyList()
}
