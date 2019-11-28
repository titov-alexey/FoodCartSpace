package com.example.foodcartspace.entities

import android.text.style.LineHeightSpan
import com.example.foodcartspace.converter.IConvertable

class ProductEntity(name: String, density: Int) : IConvertable{

    val name : String = name
    override val density: Int = density

//    override fun convert(c1: IConvertable): IConvertable {
//
//    }


}
