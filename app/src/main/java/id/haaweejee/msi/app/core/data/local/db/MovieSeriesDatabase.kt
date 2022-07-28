package id.haaweejee.msi.app.core.data.local.db

import androidx.room.Database
import androidx.room.RoomDatabase
import id.haaweejee.msi.app.core.data.local.entity.MovieEntity
import id.haaweejee.msi.app.core.data.local.entity.SeriesEntity

@Database(entities = [MovieEntity::class, SeriesEntity::class], version = 1, exportSchema = false)
abstract class MovieSeriesDatabase : RoomDatabase() {

    abstract fun movieDao() : MovieDao
    abstract fun seriesDao() : SeriesDao

}