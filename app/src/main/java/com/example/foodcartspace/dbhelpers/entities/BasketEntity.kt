package com.example.foodcartspace.dbhelpers.entities

import androidx.annotation.ColorInt
import androidx.room.*


@Entity(foreignKeys = arrayOf((ForeignKey(
    entity = BasketsNameEntity::class,
    parentColumns = arrayOf("basket_id"),
    childColumns = arrayOf("fk_basket_id"),
    onDelete = ForeignKey.CASCADE))),
    indices = [Index("fk_basket_id")],
    tableName = "Baskets")
data class BasketEntity(
    @PrimaryKey(autoGenerate = true ) val id: Long?,
    @ColumnInfo(name = "fk_basket_id") val fk_basket_id: Long,
    @ColumnInfo(name = "p_name") val p_name: String,
    @ColumnInfo(name = "quantity") val quantity: Float,
    @ColumnInfo(name = "measure") val measure: String
    )


