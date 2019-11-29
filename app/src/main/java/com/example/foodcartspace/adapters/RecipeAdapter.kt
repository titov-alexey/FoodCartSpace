package com.example.foodcartspace.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.NumberPicker
import androidx.recyclerview.widget.RecyclerView
import com.example.foodcartspace.R
import com.example.foodcartspace.entities.ProductEntity

class RecipeAdapter(val items: ArrayList<ProductEntity>) : RecyclerView.Adapter<RecipeAdapter.ViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view: View = LayoutInflater.from(parent.context).inflate(R.layout.item_recipe_main, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return items.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.numberPicker.minValue = 1
        holder.numberPicker.maxValue = 100
        holder.editNumber.text.insert(0,"0")
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val numberPicker : NumberPicker = itemView.findViewById(R.id.numberPicker)
        val editNumber : EditText = itemView.findViewById(R.id.editNumber)
    }
}