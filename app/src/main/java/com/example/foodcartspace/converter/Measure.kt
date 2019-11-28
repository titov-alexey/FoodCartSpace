package com.example.foodcartspace.converter

class Measure(val product: IConvertable, val name: String, val volume: Float ) {

//    val name: String = "Б. ложка"

//    private val volume: Float = 18.0F

    fun getMass(): Float {
        return (product.density * volume) * 1000
    }


}