package com.example.foodcartspace.adapters

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.core.content.ContextCompat.startActivity
import androidx.recyclerview.widget.RecyclerView
import com.example.foodcartspace.R
import com.example.foodcartspace.activities.BasketEditorActivity
import com.example.foodcartspace.dbhelpers.entities.BasketEntity
import com.example.foodcartspace.dbhelpers.entities.BasketsNameEntity

class BasketAdapter(val baskets: ArrayList<BasketsNameEntity>) : RecyclerView.Adapter<BasketAdapter.ViewHolder>() {

    override fun getItemCount() = baskets.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bottomTitle.text = baskets[position].basket_name
        holder.itemView.setOnClickListener{
            val intent = Intent(it.context, BasketEditorActivity::class.java)
            intent.putExtra("fk_basket_id", baskets[position].basket_id)
            intent.putExtra("basket_name", baskets[position].basket_name)
            startActivity(it.context,intent,null)
        }

    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view: View = LayoutInflater.from(parent.context).inflate(R.layout.basket_card, parent, false)
        return ViewHolder(view)
    }


    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        val bottomTitle: TextView =itemView.findViewById(R.id.bottomTitle)
    }
}