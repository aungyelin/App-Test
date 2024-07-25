package dev.yelinaung.apptest.database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import dev.yelinaung.apptest.database.entity.Product

@Dao
interface ProductDAO {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(product: Product)

    @Insert
    fun insertAll(vararg product: Product)

    @Insert
    fun insertAll(products: List<Product>)

}