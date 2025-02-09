package com.seomseom.database.di

import android.content.Context
import androidx.room.Room
import com.seomseom.database.SeomDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class DaoModule {
    @Provides
    @Singleton
    fun provideSampleDao(
        database: SeomDatabase
    ) = database.getSampleDao()
}

@Module
@InstallIn(SingletonComponent::class)
class DatabaseModule {
    @Provides
    @Singleton
    fun provideSeomDatabase(
        @ApplicationContext
        context: Context
    ): SeomDatabase {
        return Room.databaseBuilder(
            context = context,
            klass = SeomDatabase::class.java,
            name = SeomDatabase.DATABASE_NAME
        ).build()
    }
}