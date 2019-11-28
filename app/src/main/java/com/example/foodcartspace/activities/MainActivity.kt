package com.example.foodcartspace.activities

import android.content.ContentValues
import android.content.Context
import android.content.Intent
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import android.view.Menu
import android.view.MenuItem
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.foodcartspace.BuildConfig
import com.example.foodcartspace.adapters.BasketAdapter
import com.example.foodcartspace.R
import com.example.foodcartspace.entities.DBHelper

import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.content_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)

        val baskets: ArrayList<String> = ArrayList()
        val db = DBHelper(this)

        baskets.add("new_basket")



        basket_recycle_view.layoutManager = LinearLayoutManager(this, RecyclerView.HORIZONTAL, false)
        basket_recycle_view.adapter = BasketAdapter(baskets)

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


