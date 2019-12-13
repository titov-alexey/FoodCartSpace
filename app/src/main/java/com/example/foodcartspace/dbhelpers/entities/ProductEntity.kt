package com.example.foodcartspace.dbhelpers.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
//class ProductEntity(val name: String, density: Int?) : IConvertable{
//
//    override val density: Int? = density //плотность
//
//}

@Entity(tableName = "Products")
data class ProductEntity(
    @PrimaryKey(autoGenerate = true) val id: Long?,
    @ColumnInfo(name = "name") val name: String,
    @ColumnInfo(name = "density") val density: Int?
)
