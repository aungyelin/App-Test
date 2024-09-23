package dev.yelinaung.apptest.helper

import android.app.Application
import androidx.room.Room
import androidx.room.migration.Migration
import dagger.hilt.android.HiltAndroidApp
import dev.yelinaung.apptest.database.DatabaseConfigs
import dev.yelinaung.apptest.database.MyDatabase
import dev.yelinaung.apptest.database.migration.Migration1to2
import dev.yelinaung.apptest.di.koin.appModule
import dev.yelinaung.apptest.di.koin.networkModule
import dev.yelinaung.apptest.di.koin.repoModule
import dev.yelinaung.apptest.di.koin.vmModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.component.KoinComponent
import org.koin.core.context.startKoin

@HiltAndroidApp
class MyApp : Application(), KoinComponent {

    lateinit var db: MyDatabase


    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidLogger()
            androidContext(this@MyApp)
            modules(appModule, networkModule, repoModule, vmModule)
        }

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