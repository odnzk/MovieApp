package com.study.data.model

data class MovieDto(
    val completed: Boolean, // false
    val countries: List<CountryDto>,
    val coverUrl: String, // https://avatars.mds.yandex.net/get-ott/1672343/2a0000016cc7177239d4025185c488b1bf43/orig
    val description: String, // Жизнь Томаса Андерсона разделена на две части:
    val editorAnnotation: String, // Фильм доступен только на языке оригинала с русскими субтитрами
    val endYear: Int, // 1996
    val filmLength: Int, // 136
    val genres: List<GenreDto>,
    val has3D: Boolean, // false
    val hasImax: Boolean, // false
    val imdbId: String, // tt0133093
    val isTicketsAvailable: Boolean, // false
    val kinopoiskId: Int, // 301
    val lastSync: String, // 2021-07-29T20:07:49.109817
    val logoUrl: String, // https://avatars.mds.yandex.net/get-ott/1648503/2a00000170a5418408119bc802b53a03007b/orig
    val nameEn: String, // The Matrix
    val nameOriginal: String, // The Matrix
    val nameRu: String, // Матрица
    val posterUrl: String, // https://kinopoiskapiunofficial.tech/images/posters/kp/301.jpg
    val posterUrlPreview: String, // https://kinopoiskapiunofficial.tech/images/posters/kp_small/301.jpg
    val productionStatus: String, // POST_PRODUCTION
    val ratingAgeLimits: String, // age16
    val ratingAwait: Double, // 7.8
    val ratingAwaitCount: Int, // 2
    val ratingFilmCritics: Double, // 7.8
    val ratingFilmCriticsVoteCount: Int, // 155
    val ratingGoodReview: Double, // 88.9
    val ratingGoodReviewVoteCount: Int, // 257
    val ratingImdb: Double, // 8.7
    val ratingImdbVoteCount: Int, // 1729087
    val ratingKinopoisk: Double, // 8.5
    val ratingKinopoiskVoteCount: Int, // 524108
    val ratingMpaa: String, // r
    val ratingRfCritics: Double, // 7.8
    val ratingRfCriticsVoteCount: Int, // 31
    val reviewsCount: Int, // 293
    val serial: Boolean, // false
    val shortDescription: String, // Хакер Нео узнает, что его мир — виртуальный. Выдающийся экшен,
    // доказавший, что зрелищное кино может быть умным
    val shortFilm: Boolean, // false
    val slogan: String, // Добро пожаловать в реальный мир
    val startYear: Int, // 1996
    val type: String, // FILM
    val webUrl: String, // https://www.kinopoisk.ru/film/301/
    val year: Int // 1999
)
