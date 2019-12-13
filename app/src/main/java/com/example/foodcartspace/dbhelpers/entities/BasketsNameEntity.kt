package com.example.foodcartspace.dbhelpers.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "BasketsName")
data class BasketsNameEntity (
    @PrimaryKey(autoGenerate = true) val basket_id: Long?,
    @ColumnInfo(name="basket_name") val basket_name: String
)

