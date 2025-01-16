package com.faristol.minimalmathalarm.domain.usecase

import com.faristol.minimalmathalarm.data.repository.AlarmRepositoryImpl
import com.faristol.minimalmathalarm.domain.mapper.AlarmMapperImpl
import com.faristol.minimalmathalarm.domain.model.Alarm

class GetAlarmByIdUseCase(private val repo: AlarmRepositoryImpl, private val mapper: AlarmMapperImpl) {
    suspend operator fun invoke(id:Int):Alarm?{
        val alarm = repo.getAlarmById(id)
        return alarm?.let { mapper.mapToAlarmDomainModel(it) }
    }
}