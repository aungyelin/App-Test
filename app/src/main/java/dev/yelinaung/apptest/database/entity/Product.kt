package dev.yelinaung.apptest.database.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import dev.yelinaung.apptest.database.DatabaseConfigs
import java.io.Serializable

@Entity(tableName = DatabaseConfigs.TABLE_PRODUCT)
data class Product(
    @PrimaryKey(autoGenerate = true)
    val id: Int,

    @ColumnInfo(name = "name")
    val name: String,

    @ColumnInfo(name = "description")
    val description: String,

    @ColumnInfo(name = "price")
    val price: Double,

    @ColumnInfo(name = "brand")
    val brand: String,
): Serializable
