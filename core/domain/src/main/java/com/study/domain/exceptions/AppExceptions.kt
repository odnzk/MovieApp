package com.study.domain.exceptions

open class AppException : RuntimeException()

class NetworkException(val code: Int) : AppException()

class ConnectionLostException : AppException()

class InvalidMovieIdException : AppException()
