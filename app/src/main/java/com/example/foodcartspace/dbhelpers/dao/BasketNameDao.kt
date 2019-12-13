package com.example.foodcartspace.dbhelpers.dao

import androidx.room.*
import com.example.foodcartspace.dbhelpers.entities.BasketsNameEntity

@Dao
interface BasketNameDao {

    @Query("SELECT * FROM BasketsName")
    fun getAll(): List<BasketsNameEntity>

    @Query("SELECT * FROM BasketsName WHERE basket_id = :id")
    fun getById(id:Long): BasketsNameEntity

    @Insert
    fun insert(basketName: BasketsNameEntity): Long

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAll(basketsNames: Array<BasketsNameEntity>)

    @Delete
    fun delete(basketName: BasketsNameEntity)


}