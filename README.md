# MovieApp


 # Module Design

 | Module name        | Type                 | Description                                                      | URL |
 | -------------      | -------------        | -------------                                                    |  ------------- |         
 | `:app`             | Android Application  | MainActivity, MainApplication, Hilt setup.                |  [:app](/app/)  |
 | :popular:presentation](/popular/presentation)         | Android Library      | UI components for PopularMovies and DetailedPopularMovie screen. |[:popular:presentation](/popular/presentation)         | 
 | [:popular:domain](/popular/presentation)         | Java/Kotlin Library  | Business logic for PopularMovies and DetailedPopularMovie screens. | [:popular:domain](/popular/presentation)         |
 | [:popular:data](/popular/presentation)         | Android Library      |  Datasource for PopularMovies and DetailedPopularMovie screens. | [:popular:data](/popular/presentation)         | 
 | [:favorite:presentation](/favorite/presentation)          | Android Library  | UI components for FavoriteMovies screen. |   [:favorite:presentation](/favorite/presentation)|
 | [:favorite:domain](/favorite/domain)          |  Java/Kotlin Library | Business logic for FavoriteMovies screen. |   [:favorite:domain](/favorite/domain)          | 
 | [:favorite:data](/favorite/data)          |  Android Library | Datasource for FavoriteMovies screen. |   [:favorite:data](/favorite/data)          |
 | [:core:ui](/core/ui)          | Android Library | UI components, resources, such as icons, used by different features. |
 | [:core:database](/core/database)        | Android Library  | Local database storage using Room. |[:core:database](/core/database)        |
 | [:core:domain](/core/domain)          | Java/Kotlin Library  | Core business models and classes.    |[:core:domain](/core/domain)          | 
 | [:core:common](/core/common)          | Java/Kotlin Library  | Common classes shared between modules.     |[:core:common](/core/common)          |
