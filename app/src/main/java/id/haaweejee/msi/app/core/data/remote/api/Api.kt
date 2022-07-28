package id.haaweejee.msi.app.core.data.remote.api

import id.haaweejee.msi.app.BuildConfig
import id.haaweejee.msi.app.core.data.remote.response.movie.MovieResponse
import id.haaweejee.msi.app.core.data.remote.response.series.SeriesResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface Api {
    @GET("discover/movie")
    suspend fun getDiscover(
        @Query("api_key") apiKey: String = BuildConfig.TMDB_TOKEN,
        @Query("language") language: String= BuildConfig.ENGLISH_US,
        @Query("page") page: Int = 1
    ): MovieResponse

    @GET("discover/tv")
    suspend fun getDiscoverSeries(
        @Query("api_key") apiKey: String = BuildConfig.TMDB_TOKEN,
        @Query("language") language: String= BuildConfig.ENGLISH_US,
        @Query("page") page: Int = 1
    ) : SeriesResponse
}