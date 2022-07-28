package id.haaweejee.msi.app.core.data

import id.haaweejee.msi.app.core.domain.model.ListItem
import id.haaweejee.msi.app.core.data.local.LocalDataSource
import id.haaweejee.msi.app.core.data.remote.RemoteDataSource
import id.haaweejee.msi.app.core.utils.ApiResponse
import id.haaweejee.msi.app.core.utils.DataMapper
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject
import javax.inject.Singleton
import id.haaweejee.msi.app.core.data.remote.response.movie.Results as Movies
import id.haaweejee.msi.app.core.data.remote.response.series.Results as Series

@Singleton
class MovieSeriesRepository @Inject constructor(
    private val remote : RemoteDataSource,
    private val local : LocalDataSource
) : IMovieSeriesRepository{

    override fun discoverMovie(): Flow<Status<List<ListItem>>> {
        return object : NetworkBoundResource<List<Movies>, List<ListItem>>(){
            override fun loadDb(): Flow<List<ListItem>> = local.getListMovie().map { movies ->
                DataMapper.mapMovieEntityToListItem(movies)
            }

            override fun shouldFetch(db: List<ListItem>?): Boolean {
                return true
            }

            override suspend fun apiCall(): Flow<ApiResponse<List<Movies>>> = remote.discoverMovie()

            override suspend fun saveCallResult(data: List<Movies>, result: List<ListItem>?) {
                val insert = DataMapper.mapMovieResponseToMovieEntity(data)
                local.insertMovies(insert)
            }
        }.asFlow()
    }

    override fun discoverSeries(): Flow<Status<List<ListItem>>> {
        return object : NetworkBoundResource<List<Series>, List<ListItem>>(){
            override fun loadDb(): Flow<List<ListItem>> = local.getListSeries().map { series ->
                DataMapper.mapSeriesEntityToListItem(series)
            }

            override fun shouldFetch(db: List<ListItem>?): Boolean {
                return true
            }

            override suspend fun apiCall(): Flow<ApiResponse<List<Series>>> = remote.discoverSeries()

            override suspend fun saveCallResult(data: List<Series>, result: List<ListItem>?) {
                val insert = DataMapper.mapSeriesResponseToSeriesEntity(data)
                local.insertSeries(insert)
            }
        }.asFlow()
    }


}