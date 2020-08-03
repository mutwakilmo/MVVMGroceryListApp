package com.mutwaakil.mvvmgrocerylistapp.ui.shoppingList

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.mutwaakil.mvvmgrocerylistapp.R
import com.mutwaakil.mvvmgrocerylistapp.data.db.ShoppingDatabase
import com.mutwaakil.mvvmgrocerylistapp.data.db.entities.ShoppingItem
import com.mutwaakil.mvvmgrocerylistapp.other.ShoppingItemAdapter
import com.mutwaakil.mvvmgrocerylistapp.repositories.ShoppingRepository
import kotlinx.android.synthetic.main.activity_shopping.*

class ShoppingActivity : AppCompatActivity() {
    lateinit var viewModel: ShoppingViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_shopping)

        val database = ShoppingDatabase(this)
        val repository = ShoppingRepository(database)
        val factory = ShoppingViewModel(repository)
       val viewModel = ViewModelProviders.of(this).get(ShoppingViewModel::class.java)
      //  val viewModel = ViewModelProviders.of(this).get(ShoppingViewModel::class.java)

        //viewModel = ViewModelProvider(this, factory).get(ShoppingViewModel::class.java)

        val adapter = ShoppingItemAdapter(listOf(), viewModel)

        rvShoppingItems.layoutManager = LinearLayoutManager(this)
        rvShoppingItems.adapter = adapter

        viewModel.getAllShoppingItems().observe(this, Observer {
            adapter.items = it
            adapter.notifyDataSetChanged()
        })


        fab.setOnClickListener {
            AddShoppingItemDialog(this,
                object : AddDialogListener{
                    override fun onAddButtonClicked(item: ShoppingItem) {
                       viewModel.upsert(item)
                    }
                }).show()

        }
    }
}