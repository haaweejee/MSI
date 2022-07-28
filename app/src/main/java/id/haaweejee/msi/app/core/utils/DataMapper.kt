package id.haaweejee.msi.app.core.utils

import id.haaweejee.msi.app.core.domain.model.ListItem
import id.haaweejee.msi.app.core.data.local.entity.MovieEntity
import id.haaweejee.msi.app.core.data.local.entity.SeriesEntity
import id.haaweejee.msi.app.core.data.remote.response.movie.Results as Movies
import id.haaweejee.msi.app.core.data.remote.response.series.Results as Series

object DataMapper {
    fun mapMovieResponseToMovieEntity(movies : List<Movies>?) : List<MovieEntity>{
        val listItem = ArrayList<MovieEntity>()
        movies?.map{
            val movie = MovieEntity(
                id = it.id,
                poster = it.poster_path,
                title = it.original_title,
                date = it.release_date,
                overview = it.overview,
                backdrop = it.backdrop_path
            )
            listItem.add(movie)
        }
        return listItem
    }
    fun mapSeriesResponseToSeriesEntity(series : List<Series>?) : List<SeriesEntity>{
        val listItem = ArrayList<SeriesEntity>()
        series?.map{
            val serie = SeriesEntity(
                id = it.id,
                poster = it.poster_path,
                title = it.original_name,
                date = it.first_air_date,
                overview = it.overview,
                backdrop = it.backdrop_path
            )
            listItem.add(serie)
        }
        return listItem
    }

    fun mapMovieEntityToListItem(movies: List<MovieEntity>) : List<ListItem>{
        val listItem = ArrayList<ListItem>()
        movies.map {
            val movie = ListItem(
                it.id,
                it.poster,
                it.title,
                it.date,
                it.overview,
                it.backdrop
            )
            listItem.add(movie)
        }
        return listItem
    }

    fun mapSeriesEntityToListItem(series: List<SeriesEntity>) : List<ListItem>{
        val listItem = ArrayList<ListItem>()
        series.map {
            val serie = ListItem(
                it.id,
                it.poster,
                it.title,
                it.date,
                it.overview,
                it.backdrop
            )
            listItem.add(serie)
        }
        return listItem
    }

}