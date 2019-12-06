package com.example.foodcartspace.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.foodcartspace.R
import com.example.foodcartspace.adapters.RecipeAdapter
import com.example.foodcartspace.converter.Measure
import com.example.foodcartspace.entities.DBHelper
import com.example.foodcartspace.entities.ProductEntity
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_recipe_editor.*
import kotlinx.android.synthetic.main.activity_recipe_editor.fab


class RecipeEditorActivity : AppCompatActivity() {


//    private var sPref = getSharedPreferences("Example.xml", Context.MODE_PRIVATE)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recipe_editor)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setDisplayShowHomeEnabled(true)
        supportActionBar?.setTitle("RecipeEditor")

        val db = DBHelper(this)

        val products = ArrayList<ProductEntity>()
        val measures = ArrayList<Measure>()
        val measureNames = ArrayList<String>()

        products.add(0, ProductEntity("",null))


        val cursor = db.getMeasures()
        if (cursor != null && cursor.count != 0) {
            cursor.moveToFirst()
            measures.add(Measure(cursor.getString(cursor.getColumnIndex("name")), cursor.getFloat(cursor.getColumnIndex("volume"))))
            measureNames.add(cursor.getString(cursor.getColumnIndex("name")))
            while (cursor.moveToNext()){
                measures.add(Measure(cursor.getString(cursor.getColumnIndex("name")), cursor.getFloat(cursor.getColumnIndex("volume"))))
                measureNames.add(cursor.getString(cursor.getColumnIndex("name")))
            }
        }

        val productAdapter = RecipeAdapter(products, measureNames.toTypedArray())

        product_recycler_view.layoutManager = LinearLayoutManager(this, RecyclerView.VERTICAL, false)
        product_recycler_view.adapter = productAdapter

        fab.setOnClickListener {
            products.add(products.size -1, ProductEntity("",null))
            productAdapter.notifyItemInserted(products.size-1)
        }

    }


    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }


}
