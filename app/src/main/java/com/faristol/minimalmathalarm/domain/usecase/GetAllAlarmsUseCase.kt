package com.faristol.minimalmathalarm.domain.usecase

import com.faristol.minimalmathalarm.data.repository.AlarmRepository
import com.faristol.minimalmathalarm.domain.mapper.AlarmMapper
import com.faristol.minimalmathalarm.domain.model.Alarm
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class GetAllAlarmsUseCase(private val repo: AlarmRepository, private val mapper: AlarmMapper) {
    operator fun invoke(): Flow<List<Alarm>> {
        return repo.getAlarms().map { entities ->
            entities.map { mapper.mapToAlarmDomainModel(it) }
        }
    }
}