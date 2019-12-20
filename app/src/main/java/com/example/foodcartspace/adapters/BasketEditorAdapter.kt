package com.example.foodcartspace.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import androidx.recyclerview.widget.RecyclerView
import com.example.foodcartspace.R
import com.example.foodcartspace.dbhelpers.entities.BasketEntity
import kotlinx.android.synthetic.main.item_basket_main.view.*


class BasketEditorAdapter(val products: ArrayList<BasketEntity>) : RecyclerView.Adapter<BasketEditorAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view: View = LayoutInflater.from(parent.context).inflate(R.layout.item_basket_main, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return products.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.productName.setText(products[position].p_name)

    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        var productName: EditText = itemView.findViewById(R.id.productName)

    }

}