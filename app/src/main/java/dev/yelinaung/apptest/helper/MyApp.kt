package dev.yelinaung.apptest.helper

import android.app.Application
import androidx.room.Room
import androidx.room.migration.Migration
import dagger.hilt.android.HiltAndroidApp
import dev.yelinaung.apptest.database.DatabaseConfigs
import dev.yelinaung.apptest.database.MyDatabase
import dev.yelinaung.apptest.database.migration.Migration1to2

@HiltAndroidApp
class MyApp : Application() {

    lateinit var db: MyDatabase


    override fun onCreate() {
        super.onCreate()

        this.initDatabase()
    }

    private fun initDatabase() {
        this.db = Room.databaseBuilder(
            applicationContext,
            MyDatabase::class.java,
            DatabaseConfigs.DATABASE_NAME
        )
            .addMigrations(Migration1to2())
            .allowMainThreadQueries()
            .build()
    }

}