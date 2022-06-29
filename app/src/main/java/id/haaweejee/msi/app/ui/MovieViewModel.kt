package id.haaweejee.msi.app.ui

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import id.haaweejee.msi.app.core.data.remote.api.RetrofitClient
import id.haaweejee.msi.app.core.data.remote.model.movie.MovieResponse
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MovieViewModel : ViewModel() {
    private val _discover = MutableLiveData<MovieResponse>()
    val discover : LiveData<MovieResponse> = _discover

    fun getDiscover(){
        viewModelScope.launch(Dispatchers.IO){
            try {
                val client = RetrofitClient.apiInstance.getDiscover()
                if (client.isSuccessful){
                    _discover.postValue(client.body())
                    Log.d("MovieViewModel", client.body().toString())

                }
            }catch (ex : Exception){
                Log.d("MovieViewModel", ex.message.toString())
            }
        }
    }
}