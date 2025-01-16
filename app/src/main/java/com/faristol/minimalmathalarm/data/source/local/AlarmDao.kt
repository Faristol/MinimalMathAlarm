package com.faristol.minimalmathalarm.data.source.local

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.faristol.minimalmathalarm.data.model.AlarmEntity
import kotlinx.coroutines.flow.Flow


@Dao
interface AlarmDao {
    @Query("SELECT * FROM AlarmEntity")
    fun getAlarms() : Flow<List<AlarmEntity>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAlarm(alarm: AlarmEntity)

    @Delete
    suspend fun deleteAlarm(alarm: AlarmEntity)

}