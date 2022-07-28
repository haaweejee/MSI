package id.haaweejee.msi.app.core.data.remote.response.movie

import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class MovieResponse(
    val page : Int? = 0,
    val results : List<Results>? = null,
    val total_results : Int? = 0,
    val total_pages : Int? = 0
)
