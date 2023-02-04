package com.study.database.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.study.database.dao.MovieDao
import com.study.database.entity.MovieEntity

@Database(entities = [MovieEntity::class], version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun movieDao(): MovieDao
}
