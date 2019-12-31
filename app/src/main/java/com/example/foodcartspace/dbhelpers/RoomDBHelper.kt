package com.example.foodcartspace.dbhelpers

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.foodcartspace.dbhelpers.dao.BasketDao
import com.example.foodcartspace.dbhelpers.dao.BasketNameDao
import com.example.foodcartspace.dbhelpers.dao.MeasuresDao
import com.example.foodcartspace.dbhelpers.dao.ProductDao
import com.example.foodcartspace.dbhelpers.entities.BasketEntity
import com.example.foodcartspace.dbhelpers.entities.BasketsNameEntity
import com.example.foodcartspace.dbhelpers.entities.MeasuresEntity
import com.example.foodcartspace.dbhelpers.entities.ProductEntity

@Database(entities = [
    BasketEntity::class,
    BasketsNameEntity::class,
    MeasuresEntity::class,
    ProductEntity::class],
    version = 4)
abstract class RoomDBHelper : RoomDatabase() {

    abstract fun measuresDao(): MeasuresDao

    abstract fun productDao(): ProductDao

    abstract fun basketDao(): BasketDao

    abstract fun basketsNameDao(): BasketNameDao

}