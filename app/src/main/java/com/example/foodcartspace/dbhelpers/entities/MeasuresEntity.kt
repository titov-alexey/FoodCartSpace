package com.example.foodcartspace.dbhelpers.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "Measures")
data class MeasuresEntity(
    @PrimaryKey(autoGenerate = true) val id: Long?,
    @ColumnInfo(name = "name") val name: String,
    @ColumnInfo(name = "volume") val volume: Float?
)