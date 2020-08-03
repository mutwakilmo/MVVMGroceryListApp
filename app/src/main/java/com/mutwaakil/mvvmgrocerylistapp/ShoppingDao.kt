package com.mutwaakil.mvvmgrocerylistapp

import androidx.lifecycle.LiveData
import androidx.room.*

/**
 * Created by Mutwakil-Mo 🤩
 * Android Engineer,
 * Brussels
 */
@Dao
interface ShoppingDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend  fun upsert(item: ShoppingItem)

    @Delete
     suspend fun delete(item:ShoppingItem)

    @Query("SELECT * FROM shopping_item")
    fun getAllShoppingItems(): LiveData<List<ShoppingItem>>
}