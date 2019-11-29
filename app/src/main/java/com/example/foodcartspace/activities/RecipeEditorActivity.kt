package com.example.foodcartspace.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.foodcartspace.R
import com.example.foodcartspace.adapters.RecipeAdapter
import com.example.foodcartspace.entities.ProductEntity
import kotlinx.android.synthetic.main.activity_recipe_editor.*


class RecipeEditorActivity : AppCompatActivity() {


//    private var sPref = getSharedPreferences("Example.xml", Context.MODE_PRIVATE)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recipe_editor)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setDisplayShowHomeEnabled(true)
        supportActionBar?.setTitle("RecipeEditor")

        val products = ArrayList<ProductEntity>()
        products.add(0, ProductEntity("ass", 600))

        product_recycler_view.layoutManager = LinearLayoutManager(this, RecyclerView.VERTICAL, false)
        product_recycler_view.adapter = RecipeAdapter(products)

    }


    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }


}
