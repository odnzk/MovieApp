package com.study.movieapp.di.modules

import android.app.Application
import androidx.room.Room
import com.study.database.db.AppDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {
    private const val DATABASE_NAME = "app-database"

    @Provides
    @Singleton
    fun providesDatabase(app: Application) =
        Room.databaseBuilder(app, AppDatabase::class.java, DATABASE_NAME)
            .fallbackToDestructiveMigration()
            .build()


    @Provides
    @Singleton
    fun providesMovieDao(database: AppDatabase) = database.movieDao()

}
