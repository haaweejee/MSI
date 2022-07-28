package id.haaweejee.msi.app.core.data.local.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "movie")
data class MovieEntity(
    @PrimaryKey
    @ColumnInfo(name = "id")
    var id: Int? = 0,
    @ColumnInfo(name = "poster")
    var poster : String? = "",
    @ColumnInfo(name = "title")
    var title : String? = "",
    @ColumnInfo(name = "date")
    var date: String? = "",
    @ColumnInfo(name = "overview")
    var overview: String? = "",
    @ColumnInfo(name = "backdrop")
    var backdrop: String? = "",
)
