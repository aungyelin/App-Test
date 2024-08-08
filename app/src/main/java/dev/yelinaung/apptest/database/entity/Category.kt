package dev.yelinaung.apptest.database.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import dev.yelinaung.apptest.database.DatabaseConfigs

@Entity(tableName = DatabaseConfigs.TABLE_CATEGORY)
data class Category(
    @PrimaryKey(autoGenerate = true)
    val id: Int,

    @ColumnInfo(name = "name")
    val name: String,

    @ColumnInfo(name = "description")
    val description: String,
)
