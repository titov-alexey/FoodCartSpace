package com.example.foodcartspace.dbhelpers.dao

import androidx.room.*
import com.example.foodcartspace.dbhelpers.entities.BasketEntity
import com.example.foodcartspace.dbhelpers.entities.BasketsNameEntity


@Dao
interface BasketDao {

    @Query("SELECT * FROM Baskets")
    fun getAll(): List<BasketEntity>

    @Query("SELECT * FROM Baskets WHERE id = :id")
    fun getById(id:Long): BasketEntity

    @Insert
    fun insert(basket: BasketEntity)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAll(baskets: List<BasketEntity>)

    @Delete
    fun delete(basket: BasketEntity)

}