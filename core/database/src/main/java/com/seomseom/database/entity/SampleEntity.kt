package com.seomseom.database.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(
    tableName = "sample"
)
data class SampleEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Long? = null
)
