package dev.yelinaung.apptest.database

import androidx.room.Database
import androidx.room.RoomDatabase
import dev.yelinaung.apptest.database.dao.CategoryDAO
import dev.yelinaung.apptest.database.dao.ProductDAO
import dev.yelinaung.apptest.database.entity.Category
import dev.yelinaung.apptest.database.entity.Product

@Database(
    entities = [Product::class, Category::class],
    version = DatabaseConfigs.DATABASE_VERSION,
    exportSchema = true
)
abstract class MyDatabase : RoomDatabase() {

    abstract fun productDAO(): ProductDAO
    abstract fun categoryDAO(): CategoryDAO

}