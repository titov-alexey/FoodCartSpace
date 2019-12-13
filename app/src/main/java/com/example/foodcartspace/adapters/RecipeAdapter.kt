package com.example.foodcartspace.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText

import androidx.recyclerview.widget.RecyclerView
import com.example.foodcartspace.R
import com.example.foodcartspace.dbhelpers.entities.ProductEntity
import com.shawnlin.numberpicker.NumberPicker

class RecipeAdapter(val items: ArrayList<ProductEntity>, val measureNames: Array<String>) : RecyclerView.Adapter<RecipeAdapter.ViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view: View = LayoutInflater.from(parent.context).inflate(R.layout.item_recipe_main, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return items.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.numberPicker.minValue = 1
        holder.numberPicker.maxValue = measureNames.size
        holder.numberPicker.displayedValues = measureNames
        holder.numberPicker.value =1
        holder.numberPicker.lineSpacingMultiplier = 1.5F
        holder.productName.setText(items[position].name)
    }



    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val numberPicker : NumberPicker = itemView.findViewById(R.id.numberPicker)
        val productCount : EditText = itemView.findViewById(R.id.productCount)
        val productName : EditText = itemView.findViewById(R.id.productName)
    }
}