# MovieApp

## Функционал
**Основные требования:**
- [X] На главном экране необходимо отображать список популярных фильмов.
- [X] В каждой карточке фильма на главной странице должны содержаться следующие элементы: наименование фильма, изображение-постер фильма, год выпуска.
- [X] При клике на карточку открывается экран с постером фильма, описанием, жанром, страной производства.
- [X] Если сеть недоступна или в процессе загрузки произошла ошибка, необходимо предусмотреть уведомление пользователя об этом.

**Необязательные требования:**
- [X] На главном экране присутствуют разделы «Популярное» и «Избранное». При длительном клике на карточку, фильм помещается в избранное и хранится в базе данных. Карточки фильмов из избранного доступны в оффлайн-режиме.
- [X] При просмотре популярных, выделяются фильмы, находящиеся в избранном.
- [X] В разделах доступен поиск фильмов по наименованию (в соответствии с выбранным разделом).
</br>

**Также:**
- [X] Приложение написано на Kotlin.
- [X] Обеспечена общая плавность и стабильность приложения.
- [X] Во время длительных загрузок, отображаются шиммеры/прогресс бары.
- [X] Ответы от API должны быть закешированы хотя бы на время сессии.

- [X] Модуляризация
- [X] Clean Architecture
- [X] Single Activity Application
- [X] Swipe to delete: удаление фильма из избранного свайпом


## Модуляризация

| Module name             | Type                | Description                                                         | URL                                              |
|-------------------------|---------------------|---------------------------------------------------------------------|--------------------------------------------------|         
| `:app`                  | Android Application | MainActivity, MainApplication, Hilt setup.                          | [:app](/app/)                                    |
| `popular:presentation`  | Android Library     | UI components for PopularMovies and DetailedPopularMovie screen.    | [:popular:presentation](/popular/presentation)   | 
| `popular:domain`        | Java/Kotlin Library | Business logic for PopularMovies and DetailedPopularMovie screens.  | [:popular:domain](/popular/presentation)         |
| `popular:data`          | Android Library     | Datasource for PopularMovies and DetailedPopularMovie screens.      | [:popular:data](/popular/presentation)           | 
| `favorite:presentation` | Android Library     | UI components for FavoriteMovies screen.                            | [:favorite:presentation](/favorite/presentation) |
| `favorite:domain`       | Java/Kotlin Library | Business logic for FavoriteMovies screen.                           | [:favorite:domain](/favorite/domain)             | 
| `favorite:data`         | Android Library     | Datasource for FavoriteMovies screen.                               | [:favorite:data](/favorite/data)                 |
| `core:ui`               | Android Library     | UI components, resources, such as icons, used by different features. | [:core:ui](/core/ui)                             |
| `core:database`         | Android Library     | Local database storage using Room.                                  | [:core:database](/core/database)                 |
| `core:domain`           | Java/Kotlin Library | Core business models and classes.                                   | [:core:domain](/core/domain)                     | 
| `core:common`           | Java/Kotlin Library | Common classes shared between modules.                              | [:core:common](/core/common)                     | 
| `core:network`          | Android Library     | Network requests and handling responses from a remote data source.  | [:core:network](/core/network)                   | 


## Скриншоты
<p align="center">
<img src="https://raw.githubusercontent.com/Odenezhkina/MovieApp/master/.github/images/screenshots.png?token=GHSAT0AAAAAABXVLB4UJTR2AXJ63N2KAILAY67V3PQ" height="400px">
</p>

## Объяснения некоторых решений
- В качестве навигации между популярными и избранными фильмами было выбрано BottomNavigationView, так как обычно в приложениях под андроид используется именно оно в случаях 2 "равноправных" вкладок, к тому же к нему легко подключить NavigationComponent, а время для выполнения задания ограничено
