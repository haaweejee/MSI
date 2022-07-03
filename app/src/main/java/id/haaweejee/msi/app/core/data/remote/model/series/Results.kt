package id.haaweejee.msi.app.core.data.remote.model.series

import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class Results(
    var id: Int? = 0,
    var poster_path : String? = "",
    var original_name: String? = "",
    var first_air_date: String? = "",
    var overview: String? = "",
    var backdrop_path: String? = "",
)
