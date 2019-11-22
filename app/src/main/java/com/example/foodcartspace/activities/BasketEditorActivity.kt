package com.example.foodcartspace.activities

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.foodcartspace.R
import kotlinx.android.synthetic.main.activity_basket_editor.*

class BasketEditorActivity : AppCompatActivity() {


//    private var sPref = getSharedPreferences("Example.xml", Context.MODE_PRIVATE)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_basket_editor)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setDisplayShowHomeEnabled(true)
        supportActionBar?.setTitle("BasketEditor")

        number_picker.minValue = 1
        number_picker.maxValue = 10
    }


    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }
}