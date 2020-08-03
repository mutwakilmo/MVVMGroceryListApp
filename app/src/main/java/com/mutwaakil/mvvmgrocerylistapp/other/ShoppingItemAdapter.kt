package com.mutwaakil.mvvmgrocerylistapp.other

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.view.menu.ActionMenuItemView
import androidx.recyclerview.widget.RecyclerView
import com.mutwaakil.mvvmgrocerylistapp.R
import com.mutwaakil.mvvmgrocerylistapp.data.db.entities.ShoppingItem
import com.mutwaakil.mvvmgrocerylistapp.ui.shoppingList.ShoppingViewModel
import kotlinx.android.synthetic.main.shopping_item.view.*

/**
 * Created by Mutwakil-Mo 🤩
 * Android Engineer,
 * Brussels
 */
class ShoppingItemAdapter (
    var items :List<ShoppingItem>,
    private val viewModel : ShoppingViewModel
) : RecyclerView.Adapter<ShoppingItemAdapter.ShoppingViewHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ShoppingViewHolder {
       val view = LayoutInflater.from(parent.context).inflate(R.layout.shopping_item, parent, false)
        return ShoppingViewHolder(view)
    }

    override fun getItemCount(): Int {
          return items.size
    }

    override fun onBindViewHolder(holder: ShoppingViewHolder, position: Int) {
        val curShoppingItem = items[position]
        holder.itemView.tvName.text = curShoppingItem.name
        holder.itemView.tvAmount.text = "${curShoppingItem.amount}"

        holder.itemView.ivPlus.setOnClickListener {
            curShoppingItem.amount++
            viewModel.upsert(curShoppingItem)
        }

        holder.itemView.ivDelete.setOnClickListener {
            if (curShoppingItem.amount > 0){
                curShoppingItem.amount--
                viewModel.upsert(curShoppingItem)
            }
        }

    }

    inner class ShoppingViewHolder(itemView: View) :RecyclerView.ViewHolder(itemView)
}