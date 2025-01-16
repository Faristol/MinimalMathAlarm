package com.faristol.minimalmathalarm.domain.usecase

import com.faristol.minimalmathalarm.data.repository.AlarmRepositoryImpl
import com.faristol.minimalmathalarm.domain.mapper.AlarmMapperImpl
import com.faristol.minimalmathalarm.domain.model.Alarm


class DeleteAlarmUseCase(private val repo: AlarmRepositoryImpl, private val mapper: AlarmMapperImpl) {
    suspend operator fun invoke(alarm: Alarm){
        val alarmEntity = mapper.mapToAlarmEntityModel(alarm)
        return repo.deleteAlarm(alarmEntity)
    }

}
