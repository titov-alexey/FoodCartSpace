package com.example.foodcartspace.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.foodcartspace.App
import com.example.foodcartspace.R
import com.example.foodcartspace.adapters.RecipeAdapter
import com.example.foodcartspace.converter.Measure
import com.example.foodcartspace.dbhelpers.DBHelper
import com.example.foodcartspace.dbhelpers.RoomDBHelper
import com.example.foodcartspace.dbhelpers.entities.ProductEntity
import kotlinx.android.synthetic.main.activity_recipe_editor.*
import kotlinx.android.synthetic.main.activity_recipe_editor.fab


class RecipeEditorActivity : AppCompatActivity() {


//    private var sPref = getSharedPreferences("Example.xml", Context.MODE_PRIVATE)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val db = App.getAppInstance().database
        setContentView(R.layout.activity_recipe_editor)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setDisplayShowHomeEnabled(true)
        supportActionBar?.setTitle("RecipeEditor")

        val productDao = db.productDao()
        val measureDao = db.measuresDao()

        val products = ArrayList<ProductEntity>()
        val measures = ArrayList<Measure>()
        val measureNames = ArrayList<String>()


        products.addAll(productDao.getAll())

        if (products.isEmpty()){
            products.add(0,
                ProductEntity(0, "", 1)
            )
        }

        for (i in measureDao.getAll()){
            measures.add(Measure(i.name, i.volume))
            measureNames.add(i.name)
        }


        val productAdapter = RecipeAdapter(products, measureNames.toTypedArray())

        product_recycler_view.layoutManager = LinearLayoutManager(this, RecyclerView.VERTICAL, false)
        product_recycler_view.adapter = productAdapter

        fab.setOnClickListener {
            products.add(products.size -1,
                ProductEntity(
                    null,
                    "",
                    null
                )
            )
            productAdapter.notifyItemInserted(products.size-1)
        }

    }


    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }


}
