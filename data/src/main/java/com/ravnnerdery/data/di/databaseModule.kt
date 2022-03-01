package com.ravnnerdery.data.di

import android.content.Context
import androidx.room.Room
import com.ravnnerdery.data.database.DatabaseDao
import com.ravnnerdery.data.database.StarWarsDataBase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

private const val STAR_WARS_DATABASE = "StarWarsDatabase"

@InstallIn(SingletonComponent::class)
@Module
class DatabaseModule {
    @Provides
    @Singleton
    fun provideDatabaseDao(articlesDatabase: StarWarsDataBase): DatabaseDao {
        return articlesDatabase.databaseDao()
    }

    @Provides
    @Singleton
    fun provideStarWarsDatabase(@ApplicationContext appContext: Context): StarWarsDataBase {
        return Room.databaseBuilder(
            appContext,
            StarWarsDataBase::class.java,
            STAR_WARS_DATABASE
        )
            .fallbackToDestructiveMigration()
            .build()
    }
}