package com.example.foodcartspace.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
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

        product_recycler_view.adapter = RecipeAdapter(products)
//        for (i in 1..15){
//            saveText(i.toString(), "TEST")
//        }
//
//
//
//    }
//
//    fun saveText(id: String, text: String) {
//        sPref = getPreferences(Context.MODE_PRIVATE)
//        val ed = sPref.edit()
//        ed.putString(id, text)
//        ed.apply()
////        Toast.makeText(this, "Text saved", Toast.LENGTH_SHORT).show()
    }


    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }


}
