package id.haaweejee.msi.app.core.data.remote.response.movie

import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class Results(
    var id: Int? = 0,
    var poster_path : String? = "",
    var original_title: String? = "",
    var release_date: String? = "",
    var overview: String? = "",
    var backdrop_path: String? = "",
)
