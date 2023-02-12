package com.study.network.utils

internal fun String?.capitalizeOrEmpty(): String =
    this?.replaceFirstChar { char -> char.uppercaseChar() } ?: orEmpty()
