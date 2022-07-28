package id.haaweejee.msi.app.ui.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import dagger.hilt.android.lifecycle.HiltViewModel
import id.haaweejee.msi.app.core.domain.usecase.MovieSeriesUseCase
import javax.inject.Inject

@HiltViewModel
class MovieViewModel @Inject constructor(useCase: MovieSeriesUseCase) : ViewModel() {

   val movie = useCase.discoverMovie().asLiveData()
   val series = useCase.discoverSeries().asLiveData()

}