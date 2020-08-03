package com.mutwaakil.mvvmgrocerylistapp.ui.shoppingList

import com.mutwaakil.mvvmgrocerylistapp.data.db.entities.ShoppingItem

/**
 * Created by Mutwakil-Mo 🤩
 * Android Engineer,
 * Brussels
 */
interface AddDialogListener {
    fun onAddButtonClicked(item: ShoppingItem)
}