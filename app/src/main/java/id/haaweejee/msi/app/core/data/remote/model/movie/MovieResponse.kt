package id.haaweejee.msi.app.core.data.remote.model.movie

data class MovieResponse(
    val page : Int? = 0,
    val results : List<Results>? = null,
    val total_results : Int? = 0,
    val total_pages : Int? = 0
)
