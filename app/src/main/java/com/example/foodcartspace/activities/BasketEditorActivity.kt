package com.example.foodcartspace.activities

import android.os.Bundle
import android.view.LayoutInflater
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.foodcartspace.App
import com.example.foodcartspace.R
import com.example.foodcartspace.adapters.BasketEditorAdapter
import com.example.foodcartspace.dbhelpers.dao.BasketDao
import com.example.foodcartspace.dbhelpers.entities.BasketEntity
import com.example.foodcartspace.dbhelpers.entities.ProductEntity
import kotlinx.android.synthetic.main.activity_basket_editor.*
import java.util.*
import kotlin.collections.ArrayList


class BasketEditorActivity : AppCompatActivity() {

    val db = App.getAppInstance().database
    var isNewBasket: Boolean = false
    val defaultValue: Long = 0

    lateinit var database: BasketDao

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_basket_editor)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setDisplayShowHomeEnabled(true)
        supportActionBar?.setTitle("BasketEditor")
        supportActionBar?.setDisplayShowCustomEnabled(true)

        var products = ArrayList<BasketEntity>()

        val database = db.basketDao()
        val fk_basket = intent.getLongExtra("fk_basket_id",defaultValue)
        isNewBasket = fk_basket == defaultValue

        if(isNewBasket){
            basket_name.setText(Calendar.getInstance().time.toString())
        } else{
            basket_name.setText(intent.getStringExtra("basket_name"))
            products.addAll(database.getAll())
        }

        product_recycler_view.layoutManager = LinearLayoutManager(this, RecyclerView.VERTICAL, false)
        product_recycler_view.adapter = BasketEditorAdapter(products)






    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_basketeditor, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean { // Handle item selection
        return when (item.itemId) {
            R.id.ok_btn -> {
//                database.insertAll() // закончил здесь
//
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }
}