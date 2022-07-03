package id.haaweejee.msi.app.ui.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import id.haaweejee.msi.app.core.data.remote.api.RetrofitClient
import id.haaweejee.msi.app.core.data.remote.model.movie.MovieResponse
import id.haaweejee.msi.app.core.data.remote.model.series.SeriesResponse
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MovieViewModel : ViewModel() {
    private val _discover = MutableLiveData<MovieResponse>()
    val discover : LiveData<MovieResponse> = _discover

    private val _discoverSeries = MutableLiveData<SeriesResponse>()
    val discoverSeries : LiveData<SeriesResponse> = _discoverSeries

    fun getDiscover(){
        viewModelScope.launch(Dispatchers.IO){
            try {
                val client = RetrofitClient.getApiService().getDiscover()
                if (client.isSuccessful){
                    _discover.postValue(client.body())
                    Log.d("MovieViewModel", client.body().toString())

                }
            }catch (ex : Exception){
                Log.d("MovieViewModel", ex.message.toString())
            }
        }
    }

    fun getDiscoverSeries(){
        viewModelScope.launch(Dispatchers.IO){
            try {
                val client = RetrofitClient.getApiService().getDiscoverSeries()
                if (client.isSuccessful){
                    _discoverSeries.postValue(client.body())
                    Log.d("MovieViewModel", client.body().toString())
                }
            }catch (ex : Exception){
                Log.d("MovieViewModel", ex.message.toString())
            }
        }
    }
}