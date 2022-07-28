package id.haaweejee.msi.app.core.data.remote

import id.haaweejee.msi.app.core.data.remote.api.Api
import id.haaweejee.msi.app.core.utils.ApiResponse
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject
import javax.inject.Singleton
import id.haaweejee.msi.app.core.data.remote.response.movie.Results as Movies
import id.haaweejee.msi.app.core.data.remote.response.series.Results as Series


@Singleton
class RemoteDataSource @Inject constructor(private val service : Api) : IRemoteDataSource {

    override suspend fun discoverMovie(): Flow<ApiResponse<List<Movies>>> {
        return flow {
            try {
                val response = service.getDiscover().results
                if (response != null) {
                    if (response.isNotEmpty()){
                        emit(ApiResponse.Success(response))
                    }else{
                        emit(ApiResponse.Empty)
                    }
                }
            }catch (e: Exception){
                emit(ApiResponse.Error(e.message.toString()))
            }
        }.flowOn(Dispatchers.IO)

    }

    override suspend fun discoverSeries(): Flow<ApiResponse<List<Series>>> {
        return flow {
            try {
                val response = service.getDiscoverSeries().results
                if (response != null) {
                    if (response.isNotEmpty()) {
                        emit(ApiResponse.Success(response))
                    } else {
                        emit(ApiResponse.Empty)
                    }
                }
            } catch (e: Exception) {
                emit(ApiResponse.Error(e.message.toString()))
            }
        }.flowOn(Dispatchers.IO)
    }
}