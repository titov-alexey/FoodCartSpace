package com.example.foodcartspace

import android.app.Application
import androidx.room.Room
import com.example.foodcartspace.dbhelpers.RoomDBHelper
import com.example.foodcartspace.dbhelpers.entities.BasketEntity
import com.example.foodcartspace.dbhelpers.entities.BasketsNameEntity
import com.example.foodcartspace.dbhelpers.entities.MeasuresEntity
import com.example.foodcartspace.dbhelpers.entities.ProductEntity

class App : Application() {

    companion object {
        var instance: App? = null

        fun getAppInstance(): App {
            return if (instance != null) {
                instance!!
            } else {
                instance =
                    App()
                instance!!
            }
        }
    }

    lateinit var database: RoomDBHelper

    override fun onCreate() {
        super.onCreate()
        instance = this
        database = Room
            .databaseBuilder(this, RoomDBHelper::class.java, "simple_db")
            .fallbackToDestructiveMigration()
            .allowMainThreadQueries()
            .build()

        fillDatabase()
    }

    fun fillDatabase(){
        val productDao = database.productDao()
        val measuresDao = database.measuresDao()
        val basketDao = database.basketDao()
        val basketsNameDao = database.basketsNameDao()

        basketsNameDao.insertAll(arrayOf(
            BasketsNameEntity(basket_id = 2, basket_name = "Пример")))

        basketDao.insert(BasketEntity(null, 2, "", 1.0F, "бочка"))

        measuresDao.insertAll(arrayOf(MeasuresEntity(null, "Б. ложка", 18.0F),
            MeasuresEntity(null, "М. Ложка", 5.0F)))

        productDao.insert(ProductEntity( null, "Картошка", 1))

    }


}