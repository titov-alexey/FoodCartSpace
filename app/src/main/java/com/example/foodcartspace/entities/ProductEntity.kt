package com.example.foodcartspace.entities

import android.text.style.LineHeightSpan
import com.example.foodcartspace.converter.IConvertable

class ProductEntity(val name: String, density: Int) : IConvertable{

    override val density: Int? = density //плотность

}
