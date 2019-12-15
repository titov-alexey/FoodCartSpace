package com.example.foodcartspace.activities

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import com.example.foodcartspace.App
import com.example.foodcartspace.R
import com.example.foodcartspace.dbhelpers.dao.BasketDao
import kotlinx.android.synthetic.main.activity_basket_editor.*
import java.util.*


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

        number_picker.minValue = 1
        number_picker.maxValue = 10

        val database = db.basketDao()
        val fk_basket = intent.getLongExtra("fk_basket_id",defaultValue)
        isNewBasket = fk_basket == defaultValue

        if(isNewBasket){
            basket_name.setText(Calendar.getInstance().time.toString())
        } else{
            basket_name.setText(intent.getStringExtra("basket_name"))
        }





    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_basketeditor, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean { // Handle item selection
        return when (item.itemId) {
            R.id.ok_btn -> {
                database.insertAll() // закончил здесь

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