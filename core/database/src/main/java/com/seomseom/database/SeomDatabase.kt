package com.seomseom.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.seomseom.database.dao.SampleDao
import com.seomseom.database.entity.SampleEntity

@Database(
    entities = [
        SampleEntity::class
    ],
    version = SeomDatabase.DATABASE_VERSION,
    exportSchema = false
)
abstract class SeomDatabase : RoomDatabase() {
    abstract fun getSampleDao(): SampleDao

    companion object {
        const val DATABASE_NAME = "sample.db"
        const val DATABASE_VERSION = 1
    }
}