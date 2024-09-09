package dev.yelinaung.apptest.di.hilt

import android.content.Context
import androidx.room.Room
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent
import dagger.hilt.android.qualifiers.ApplicationContext
import dev.yelinaung.apptest.database.DatabaseConfigs
import dev.yelinaung.apptest.database.MyDatabase
import dev.yelinaung.apptest.database.migration.Migration1to2

@Module
@InstallIn(ActivityComponent::class)
abstract class HiltModule {

    @Binds
    abstract fun bindEngine(engine: EngineImpl): Engine

    /*@Provides
    fun provideDatabase(@ApplicationContext context: Context): MyDatabase {
        return Room.databaseBuilder(
            context,
            MyDatabase::class.java,
            DatabaseConfigs.DATABASE_NAME
        )
            .addMigrations(Migration1to2())
            .allowMainThreadQueries()
            .build()
    }*/

}
