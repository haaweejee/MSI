package id.haaweejee.msi.app.core.domain.usecase

import id.haaweejee.msi.app.core.data.Status
import id.haaweejee.msi.app.core.domain.model.ListItem
import kotlinx.coroutines.flow.Flow

interface MovieSeriesUseCase {
    fun discoverMovie() : Flow<Status<List<ListItem>>>
    fun discoverSeries() : Flow<Status<List<ListItem>>>
}