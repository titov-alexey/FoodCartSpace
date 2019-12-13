package com.example.foodcartspace.dbhelpers.dao

import androidx.room.*
import com.example.foodcartspace.dbhelpers.entities.MeasuresEntity

@Dao
interface MeasuresDao {

    @Query("SELECT * FROM Measures")
    fun getAll(): List<MeasuresEntity>

    @Query("SELECT * FROM Measures WHERE id = :id")
    fun getById(id:Long): MeasuresEntity

    @Insert
    fun insert(measure: MeasuresEntity)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAll(measures: Array<MeasuresEntity>)

    @Delete
    fun delete(measure: MeasuresEntity)
}
