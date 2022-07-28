package id.haaweejee.msi.app.core.data.local

import id.haaweejee.msi.app.core.data.local.db.MovieDao
import id.haaweejee.msi.app.core.data.local.db.SeriesDao
import id.haaweejee.msi.app.core.data.local.entity.MovieEntity
import id.haaweejee.msi.app.core.data.local.entity.SeriesEntity
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class LocalDataSource @Inject constructor(
    private val movieDao: MovieDao,
    private val seriesDao: SeriesDao
    ){

    fun getListMovie() : Flow<List<MovieEntity>> = movieDao.get()

    fun getListSeries() : Flow<List<SeriesEntity>> = seriesDao.get()

    suspend fun insertMovies(movies: List<MovieEntity>) = movieDao.insert(movies)

    suspend fun insertSeries(series: List<SeriesEntity>) = seriesDao.insert(series)
}