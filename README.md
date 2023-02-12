# MovieApp [in progress]

## Features
- [X] Modularization
- [X] Clean Architecture
- [X] Single Activity Application

## Modularization

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


## Screenshots
<p align="center">
<img src="https://github.com/Odenezhkina/MovieApp/blob/master/.github/images/screenshots.png" height="300px">
</p>

