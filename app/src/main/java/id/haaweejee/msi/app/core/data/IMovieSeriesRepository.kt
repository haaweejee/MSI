package id.haaweejee.msi.app.core.data

import id.haaweejee.msi.app.core.domain.model.ListItem
import kotlinx.coroutines.flow.Flow

interface IMovieSeriesRepository {

    fun discoverMovie() : Flow<Status<List<ListItem>>>

    fun discoverSeries() : Flow<Status<List<ListItem>>>

}