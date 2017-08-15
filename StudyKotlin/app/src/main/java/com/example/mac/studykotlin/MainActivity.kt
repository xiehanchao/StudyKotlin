package com.example.mac.studykotlin

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import org.jetbrains.anko.db.*

interface ISports {
    fun doSports()
}

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        println(App.instance)
        var f=ForecastDbHelper()

    }
}


class ForecastDbHelper(ctx: Context = App.instance) : ManagedSQLiteOpenHelper(ctx, ForecastDbHelper.DB_NAME, null, ForecastDbHelper.DB_VERSION) {

    companion object {
        val DB_NAME = "forecast.db"
        val DB_VERSION = 1
        val instance by lazy { ForecastDbHelper() }
    }

    override fun onCreate(db: SQLiteDatabase) {
        println("db = [${db}]")
        db.createTable(CityForecastTable.NAME, true,
                CityForecastTable.ID to INTEGER + PRIMARY_KEY,
                CityForecastTable.CITY to TEXT,
                CityForecastTable.COUNTRY to TEXT)

        db.createTable(DayForecastTable.NAME, true,
                DayForecastTable.ID to INTEGER + PRIMARY_KEY + AUTOINCREMENT,
                DayForecastTable.DATE to INTEGER,
                DayForecastTable.DESCRIPTION to TEXT,
                DayForecastTable.HIGH to INTEGER,
                DayForecastTable.LOW to INTEGER,
                DayForecastTable.ICON_URL to TEXT,
                DayForecastTable.CITY_ID to INTEGER)
    }

    override fun onUpgrade(db: SQLiteDatabase, oldVersion: Int, newVersion: Int) {
        println("db = [${db}], oldVersion = [${oldVersion}], newVersion = [${newVersion}]")

        db.dropTable(CityForecastTable.NAME, true)
        db.dropTable(DayForecastTable.NAME, true)
        onCreate(db)
    }
}
