package com.study.database.dao

import androidx.room.*
import com.study.database.entity.MovieEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface MovieDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(vararg movieEntity: MovieEntity)

    @Update(onConflict = OnConflictStrategy.REPLACE)
    suspend fun update(vararg movieEntity: MovieEntity)

    @Delete
    suspend fun delete(vararg movieEntity: MovieEntity)

    @Query("SELECT * FROM ${MovieEntity.TABLE_NAME}")
    fun getAll(): Flow<List<MovieEntity>>

    @Query("SELECT id FROM ${MovieEntity.TABLE_NAME}")
    fun getALlId(): Flow<List<Int>>
}
