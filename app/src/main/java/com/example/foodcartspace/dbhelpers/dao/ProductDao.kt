package com.example.foodcartspace.dbhelpers.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.example.foodcartspace.dbhelpers.entities.ProductEntity

@Dao
interface ProductDao {

    @Query("SELECT * FROM Products")
    fun getAll(): List<ProductEntity>

    @Query("SELECT * FROM Products WHERE id = :id")
    fun getById(id:Long): ProductEntity

    @Insert
    fun insert(product: ProductEntity)

    @Delete
    fun delete(product: ProductEntity)
}
