package com.example.foodcartspace.adapters

import android.text.Editable
import android.text.TextWatcher
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import androidx.recyclerview.widget.RecyclerView
import com.example.foodcartspace.R
import com.example.foodcartspace.dbhelpers.entities.BasketEntity


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
        holder.productCount.setText(products[position].quantity.toString())

        holder.productName.addTextChangedListener(SimpleTextWatcher(position, products))
        holder.productCount.addTextChangedListener(SimpleTextWatcher(position, products))

    }



    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        var productName: EditText = itemView.findViewById(R.id.productName)
        var productCount: EditText = itemView.findViewById(R.id.productCount)
    }


    class SimpleTextWatcher(private val position: Int, private val products: ArrayList<BasketEntity>) : TextWatcher {
        override fun afterTextChanged(s: Editable?) {
            products[position].p_name = s.toString()
        }

        override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {

        }

        override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {

        }
    }
}