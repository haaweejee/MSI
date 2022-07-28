package id.haaweejee.msi.app.core.domain.usecase

import id.haaweejee.msi.app.core.data.IMovieSeriesRepository
import id.haaweejee.msi.app.core.data.Status
import id.haaweejee.msi.app.core.domain.model.ListItem
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class MovieSeriesInteractor @Inject constructor(private val repository: IMovieSeriesRepository) : MovieSeriesUseCase {
    override fun discoverMovie(): Flow<Status<List<ListItem>>> = repository.discoverMovie()
    override fun discoverSeries(): Flow<Status<List<ListItem>>> = repository.discoverSeries()
}