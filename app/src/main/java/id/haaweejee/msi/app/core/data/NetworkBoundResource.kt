package id.haaweejee.msi.app.core.data

import id.haaweejee.msi.app.core.utils.ApiResponse
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.*

abstract class NetworkBoundResource<ReqType, ResType> {
    private var result: Flow<Status<ResType>> = flow {
        val db = loadDb().firstOrNull()
        if (shouldFetch(db)){
            emit(Status.Loading())
            when(val response = apiCall().first()){
                is ApiResponse.Empty -> emitAll(loadDb().map { Status.Success(it) })
                is ApiResponse.Error -> emitAll(loadDb().map { Status.Error(it, response.errorMessage) })
                is ApiResponse.Success -> {
                    saveCallResult(response.data, db)
                    emitAll(loadDb().map { Status.Success(it) })
                }
            }
        }else emitAll(loadDb().map { Status.Success(it) })
    }

    protected abstract fun loadDb(): Flow<ResType>
    protected abstract fun shouldFetch(db : ResType?) : Boolean
    protected abstract suspend fun apiCall() : Flow<ApiResponse<ReqType>>
    protected abstract suspend fun saveCallResult(data : ReqType, result: ResType?)
    fun asFlow() = result
}