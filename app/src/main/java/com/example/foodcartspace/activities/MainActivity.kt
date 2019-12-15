package com.example.foodcartspace.activities

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import android.view.Menu
import android.view.MenuItem
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.foodcartspace.adapters.BasketAdapter
import com.example.foodcartspace.R
import com.example.foodcartspace.App
import com.example.foodcartspace.dbhelpers.entities.BasketEntity
import com.example.foodcartspace.dbhelpers.dao.BasketNameDao
import com.example.foodcartspace.dbhelpers.entities.BasketsNameEntity

import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.content_main.*

class  MainActivity : AppCompatActivity() {

    private lateinit var basketNameDao: BasketNameDao

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)
        val db = App.getAppInstance().database

        val basketsNames: ArrayList<BasketsNameEntity> = ArrayList()

        basketNameDao = db.basketsNameDao()


        for (i in db.basketsNameDao().getAll()){
            basketsNames.add(i)
        }

        basketsNames.add(0,
            BasketsNameEntity(
                    0,
                "Добавить корзину"
            )
        )



        basket_recycle_view.layoutManager = LinearLayoutManager(this, RecyclerView.HORIZONTAL, false)
        basket_recycle_view.adapter = BasketAdapter(basketsNames)

        fab.setOnClickListener {
            val intent = Intent(this, RecipeEditorActivity::class.java)
            startActivity(intent)
        }

    }



    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        return when (item.itemId) {
            R.id.action_settings -> true
            else -> super.onOptionsItemSelected(item)
        }
    }
}


