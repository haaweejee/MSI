package id.haaweejee.msi.app.core.data.remote

import id.haaweejee.msi.app.core.utils.ApiResponse
import kotlinx.coroutines.flow.Flow
import id.haaweejee.msi.app.core.data.remote.response.movie.Results as Movies
import id.haaweejee.msi.app.core.data.remote.response.series.Results as Series


interface IRemoteDataSource {
    suspend fun discoverMovie() : Flow<ApiResponse<List<Movies>>>
    suspend fun discoverSeries() : Flow<ApiResponse<List<Series>>>
}