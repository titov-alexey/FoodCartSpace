package com.example.foodcartspace.entities

import android.content.Context
import android.database.Cursor
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

        db?.execSQL("create table if not exists "+ DATABASE_TABLE_PRODUCTS + " (" +
                "id integer primary key autoincrement, " +
                "name text, " +
                "density REAL null" + ");")

        db?.execSQL("create table if not exists "+ DATABASE_TABLE_MEASURES + " (" +
                "id integer primary key autoincrement, " +
                "name text, " +
                "volume REAL" + ");")

        db?.execSQL("create table if not exists "+ DATABASE_TABLE_BASKETS_NAME + " (" +
                "basket_id integer primary key autoincrement, " +
                "basket_name text" + ");")

        db?.execSQL("create table if not exists "+ DATABASE_TABLE_BASKETS + " (" +
                "id integer primary key autoincrement, " +
                "p_name text null, " +
                "quantity REAL, " +
                "measure text, " +
                "FOREIGN KEY(basket_id) REFERENCES $DATABASE_TABLE_BASKETS_NAME(basket_id)" + ");")




        db?.execSQL("insert into $DATABASE_TABLE_PRODUCTS ([name], [density]) values ('сахар', 900)")
        db?.execSQL("insert into $DATABASE_TABLE_MEASURES ([name], [volume]) values ('Б. ложка', 18.0)")
        db?.execSQL("insert into $DATABASE_TABLE_MEASURES ([name], [volume]) values ('М. ложка', 5.0)")
        db?.execSQL("insert into $DATABASE_TABLE_MEASURES ([name], [volume]) values ('Стакан', 200.0)")
        db?.execSQL("insert into $DATABASE_TABLE_MEASURES ([name], [volume]) values ('шт.', 0.0)")
        db?.execSQL("insert into $DATABASE_TABLE_MEASURES ([name], [volume]) values ('кг.', 1000.0)")
        db?.execSQL("insert into $DATABASE_TABLE_MEASURES ([name], [volume]) values ('гр.', 1.0)")
        db?.execSQL("insert into $DATABASE_TABLE_MEASURES ([name], [volume]) values ('мл.', 1.0)")
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        db?.execSQL("drop table if exists $DATABASE_TABLE_MEASURES")
        db?.execSQL("drop table if exists $DATABASE_TABLE_BASKETS")
        db?.execSQL("drop table if exists $DATABASE_TABLE_PRODUCTS")
        onCreate(db)
    }



    companion object {

        const val DATABASE_NAME = "example.db"
        const val DATABASE_TABLE_PRODUCTS = "Products"
        const val DATABASE_TABLE_MEASURES = "Measures"
        const val DATABASE_TABLE_BASKETS = "Baskets"
        const val DATABASE_TABLE_BASKETS_NAME = "Baskets"

        const val DATABASE_VERSION = 1
    }

    fun getBaskets() : Cursor?{
        val db = this.readableDatabase
        return db.rawQuery("select * from $DATABASE_TABLE_BASKETS", null)
    }

    fun getMeasures() : Cursor?{
        val db = this.readableDatabase
        return db.rawQuery("select * from $DATABASE_TABLE_MEASURES", null)
    }
}