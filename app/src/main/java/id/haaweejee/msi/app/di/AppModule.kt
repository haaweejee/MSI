package id.haaweejee.msi.app.di

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.scopes.ViewModelScoped
import id.haaweejee.msi.app.core.domain.usecase.MovieSeriesInteractor
import id.haaweejee.msi.app.core.domain.usecase.MovieSeriesUseCase

@Module
@InstallIn(ViewModelComponent::class)
abstract class AppModule {

    @Binds
    @ViewModelScoped
    abstract fun provideMovieSeriesUsecase(movieSeriesInteractor: MovieSeriesInteractor) : MovieSeriesUseCase
}