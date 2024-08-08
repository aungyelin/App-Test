package dev.yelinaung.apptest.database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import dev.yelinaung.apptest.database.entity.Category

@Dao
interface CategoryDAO {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(category: Category)

}