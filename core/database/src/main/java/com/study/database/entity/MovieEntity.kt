package com.study.database.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.study.database.entity.MovieEntity.Companion.TABLE_NAME

@Entity(tableName = TABLE_NAME)
data class MovieEntity(
    @PrimaryKey
    val id: Int,
    val title: String,
    val genre: String,
    val year: Int?,
    @ColumnInfo(typeAffinity = ColumnInfo.BLOB)
    val imageBytes: ByteArray?
) {
    companion object {
        const val TABLE_NAME = "movies"
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as MovieEntity

        if (id != other.id) return false
        if (title != other.title) return false
        if (genre != other.genre) return false
        if (year != other.year) return false
        if (!imageBytes.contentEquals(other.imageBytes)) return false

        return true
    }

    override fun hashCode(): Int {
        var result = id
        result = 31 * result + title.hashCode()
        result = 31 * result + genre.hashCode()
        result = 31 * result + (year ?: 0)
        result = 31 * result + (imageBytes?.contentHashCode() ?: 0)
        return result
    }

}
