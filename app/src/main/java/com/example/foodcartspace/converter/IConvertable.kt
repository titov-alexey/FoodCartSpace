package com.example.foodcartspace.converter

interface IConvertable {

    /**
     * absolute unit
     * need implementation for get
     *
     * Формула рсачета массы из объема и плотности тела
     *
     *  m = p*V
     *  где:
     *      m = масса
     *      p = плотность
     *      V = объем
     *
     */
    val density: Int?


    /**
     *  convertate this conditional unit in another conditional unit
     */
//    fun convert(c1: IConvertable) : IConvertable



}