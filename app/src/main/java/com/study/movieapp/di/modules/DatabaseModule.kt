package com.study.movieapp.di.modules

import android.app.Application
import androidx.room.Room
import androidx.room.RoomDatabase
import com.study.database.db.AppDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {
    private const val DATABASE_NAME = "app-database"

    @Provides
    @Singleton
    fun providesDatabase(@ApplicationContext applicationContext: Application): RoomDatabase =
        Room.databaseBuilder(
            applicationContext,
            AppDatabase::class.java, DATABASE_NAME
        ).build()


    @Provides
    @Singleton
    fun providesMovieDao(database: AppDatabase) = database.movieDao()

}
