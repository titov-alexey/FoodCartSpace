package com.example.foodcartspace.entities

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import android.util.Log
import com.example.foodcartspace.BuildConfig

class DBHelper(context: Context) : SQLiteOpenHelper(context, DATABASE_NAME, null, DATABASE_VERSION) {

    override fun onCreate(db: SQLiteDatabase?) {
        if (BuildConfig.DEBUG){
            val TAG = "DATABASE"
            Log.d(TAG, "Creating database")
        }

        db?.execSQL("create table if not exists"+ DATABASE_TABLE_PRODUCTS + " (" +
                "id integer primary key autoincrement," +
                "name text," +
                "density REAL" + ");")

        db?.execSQL("create table if not exists"+ DATABASE_TABLE_MEASURES + " (" +
                "id integer primary key autoincrement," +
                "name text," +
                "volume REAL" + ");")

        db?.execSQL("create table if not exists"+ DATABASE_TABLE_BASKETS + " (" +
                "id integer primary key autoincrement," +
                "basket_id text foreign key" +
                "p_name text," +
                "quantity REAL" +
                "measure text" + ");")


    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {

    }

    companion object {

        private const val DATABASE_NAME = "example.db"
        private const val DATABASE_TABLE_PRODUCTS = "Products"
        private const val DATABASE_TABLE_MEASURES = "Measures"
        private const val DATABASE_TABLE_BASKETS = "Baskets"
        private const val DATABASE_VERSION = 1
    }

}