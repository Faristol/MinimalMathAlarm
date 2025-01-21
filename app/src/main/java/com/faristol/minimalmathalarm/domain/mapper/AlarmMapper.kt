package com.faristol.minimalmathalarm.domain.mapper

import com.faristol.minimalmathalarm.data.model.AlarmEntity
import com.faristol.minimalmathalarm.domain.model.Alarm

interface AlarmMapper {
    fun mapToAlarmDomainModel(entity: AlarmEntity): Alarm
    fun mapToAlarmEntityModel(domain: Alarm): AlarmEntity
}

class AlarmMapperImpl : AlarmMapper {
    override fun mapToAlarmDomainModel(entity: AlarmEntity): Alarm {
        return Alarm(
            id = entity.id,
            alarmTime = entity.alarmTime,
            alarmProblemDifficulty = entity.alarmProblemDifficulty,
            alarmProblemQuantity = entity.alarmProblemQuantity,
            alarmProblemType = entity.alarmProblemType,
            alarmTargetDays = entity.alarmTargetDays,
            alarmIsActive = entity.alarmIsActive,
            alarmVibrate = entity.alarmVibrate,
            alarmAudioUri = entity.alarmAudioUri
        )
    }

    override fun mapToAlarmEntityModel(domain: Alarm): AlarmEntity {
        return AlarmEntity(
            id = domain.id?: 0,
            alarmTime = domain.alarmTime,
            alarmProblemDifficulty = domain.alarmProblemDifficulty,
            alarmProblemQuantity = domain.alarmProblemQuantity,
            alarmProblemType = domain.alarmProblemType,
            alarmTargetDays = domain.alarmTargetDays,
            alarmIsActive = domain.alarmIsActive,
            alarmVibrate = domain.alarmVibrate,
            alarmAudioUri = domain.alarmAudioUri
        )
    }


}