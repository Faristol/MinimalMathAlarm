package com.faristol.minimalmathalarm.data.repository

import com.faristol.minimalmathalarm.data.model.AlarmEntity
import com.faristol.minimalmathalarm.data.source.local.AlarmDao
import kotlinx.coroutines.flow.Flow

interface AlarmRepository {
    fun getAlarms(): Flow<List<AlarmEntity>>
    suspend fun insertAlarm(alarmEntity: AlarmEntity)
    suspend fun deleteAlarm(alarmEntity: AlarmEntity)
    suspend fun getAlarmById(id: Int): AlarmEntity?
}

class AlarmRepositoryImpl(private val dao: AlarmDao) : AlarmRepository {
    //no cal gastar context per a flow, room + flow ja treballa la concurrencia automàticament
    // no cal posar withContext(Dispatchers.IO) pq Room i suspend ja usa un fil de fons
    override fun getAlarms(): Flow<List<AlarmEntity>> {
        return dao.getAlarms()
    }

    override suspend fun getAlarmById(id: Int): AlarmEntity? {
        return dao.getAlarmById(id)

    }

    override suspend fun insertAlarm(alarmEntity: AlarmEntity) {
        dao.insertAlarm(alarmEntity)
    }

    override suspend fun deleteAlarm(alarmEntity: AlarmEntity) {
        dao.deleteAlarm(alarmEntity)
    }
}
