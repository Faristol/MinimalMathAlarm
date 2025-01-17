package com.faristol.minimalmathalarm.domain.usecase

import com.faristol.minimalmathalarm.data.repository.AlarmRepository
import com.faristol.minimalmathalarm.domain.mapper.AlarmMapper
import com.faristol.minimalmathalarm.domain.model.Alarm


class DeleteAlarmUseCase(private val repo: AlarmRepository, private val mapper: AlarmMapper) {
    suspend operator fun invoke(alarm: Alarm) {
        val alarmEntity = mapper.mapToAlarmEntityModel(alarm)
        return repo.deleteAlarm(alarmEntity)
    }

}
