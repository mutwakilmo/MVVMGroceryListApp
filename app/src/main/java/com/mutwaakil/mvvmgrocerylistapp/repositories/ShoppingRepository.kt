package com.mutwaakil.mvvmgrocerylistapp.repositories

import com.mutwaakil.mvvmgrocerylistapp.data.db.ShoppingDatabase
import com.mutwaakil.mvvmgrocerylistapp.data.db.entities.ShoppingItem

/**
 * Created by Mutwakil-Mo 🤩
 * Android Engineer,
 * Brussels
 */
class ShoppingRepository(
    private val db: ShoppingDatabase
) {
    suspend fun upsert(item: ShoppingItem) = db.getShoppingDao().upsert(item)
    suspend fun delete(item: ShoppingItem) = db.getShoppingDao().delete(item)

    fun getAllShoppingItems() = db.getShoppingDao().getAllShoppingItems()

}