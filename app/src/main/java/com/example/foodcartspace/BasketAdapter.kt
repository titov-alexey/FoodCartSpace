package com.example.foodcartspace

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class BasketAdapter(val baskets: ArrayList<String>) : RecyclerView.Adapter<BasketAdapter.ViewHolder>() {


    override fun getItemCount() = baskets.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bottomTitle.text = "TEXT TEXT TEXT"

    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view: View = LayoutInflater.from(parent.context).inflate(R.layout.basket_card, parent, false)
        return ViewHolder(view)
    }


    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        val bottomTitle: TextView =itemView.findViewById(R.id.bottomTitle)
    }
}