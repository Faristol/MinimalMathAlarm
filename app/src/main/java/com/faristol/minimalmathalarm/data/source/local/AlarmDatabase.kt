package com.faristol.minimalmathalarm.data.source.local

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.faristol.minimalmathalarm.data.model.AlarmEntity
import com.faristol.minimalmathalarm.data.model.converters.Converters

@Database(entities = [AlarmEntity::class], version = 1)
@TypeConverters(Converters::class)
abstract class AlarmDatabase : RoomDatabase(){
    abstract val dao: AlarmDao
}