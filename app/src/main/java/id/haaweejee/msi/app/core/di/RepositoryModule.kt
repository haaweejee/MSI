package id.haaweejee.msi.app.core.di

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import id.haaweejee.msi.app.core.data.IMovieSeriesRepository
import id.haaweejee.msi.app.core.data.MovieSeriesRepository

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {

    @Binds
    abstract fun provideRepository(movieSeriesRepository: MovieSeriesRepository) : IMovieSeriesRepository
}