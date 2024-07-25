package dev.yelinaung.apptest.database

import androidx.room.Database
import androidx.room.RoomDatabase
import dev.yelinaung.apptest.database.dao.ProductDAO
import dev.yelinaung.apptest.database.entity.Product

@Database(
    entities = [Product::class],
    version = 1,
)
abstract class MyDatabase : RoomDatabase() {

    abstract fun productDAO(): ProductDAO

}