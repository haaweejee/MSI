package id.haaweejee.msi.app.core.di

import android.content.Context
import androidx.room.Room
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import id.haaweejee.msi.app.core.data.local.db.MovieDao
import id.haaweejee.msi.app.core.data.local.db.MovieSeriesDatabase
import id.haaweejee.msi.app.core.data.local.db.SeriesDao
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class DatabaseModule {

    @Singleton
    @Provides
    fun provideDatabase(@ApplicationContext context: Context) : MovieSeriesDatabase = Room.databaseBuilder(
        context.applicationContext,
        MovieSeriesDatabase::class.java,
        "MovieSeries.db"
    )
        .fallbackToDestructiveMigration()
        .build()

    @Provides
    fun provideMovieDao(database: MovieSeriesDatabase) : MovieDao = database.movieDao()

    @Provides
    fun provideSeriesDao(database: MovieSeriesDatabase) : SeriesDao = database.seriesDao()
}