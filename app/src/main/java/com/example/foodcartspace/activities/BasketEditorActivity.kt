package com.example.foodcartspace.activities

import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.foodcartspace.App
import com.example.foodcartspace.R
import com.example.foodcartspace.adapters.BasketEditorAdapter
import com.example.foodcartspace.dbhelpers.dao.BasketDao
import com.example.foodcartspace.dbhelpers.entities.BasketEntity
import kotlinx.android.synthetic.main.activity_basket_editor.*
import java.util.*
import kotlin.collections.ArrayList


class BasketEditorActivity : AppCompatActivity() {

    val db = App.getAppInstance().database
    var isNewBasket: Boolean = false
    val defaultValue: Long = 0
    var products = ArrayList<BasketEntity>()

    lateinit var database: BasketDao

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_basket_editor)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setDisplayShowHomeEnabled(true)
        supportActionBar?.setTitle("BasketEditor")
        supportActionBar?.setDisplayShowCustomEnabled(true)



        database = db.basketDao()
        val fk_basket = intent.getLongExtra("fk_basket_id",defaultValue)
        isNewBasket = fk_basket == defaultValue

        if(isNewBasket){
            basket_name.setText(Calendar.getInstance().time.toString())
            products.add(BasketEntity(null, fk_basket, "", 0.0F, "шт."))
        } else{
            basket_name.setText(intent.getStringExtra("basket_name"))
            products.addAll(database.getAll())
        }

        val basketEditorAdapter = BasketEditorAdapter(products)
        product_recycler_view.layoutManager = LinearLayoutManager(this, RecyclerView.VERTICAL, false)
        product_recycler_view.adapter = basketEditorAdapter


        fab.setOnClickListener{
            products.add(products.size -1, BasketEntity(null, fk_basket, "",0.0F, "шт."))
            basketEditorAdapter.notifyItemInserted(products.size-1)
        }





    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_basketeditor, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean { // Handle item selection
        return when (item.itemId) {
            R.id.ok_btn -> {
                database.insertAll(products)
                Log.d("Database", "${database.getAll()}")
                Toast.makeText(this, "Сохранено", Toast.LENGTH_SHORT).show()
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