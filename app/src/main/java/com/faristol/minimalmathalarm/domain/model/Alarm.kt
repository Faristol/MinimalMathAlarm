package com.faristol.minimalmathalarm.domain.model

import com.faristol.minimalmathalarm.data.model.enums.ProblemDifficulty
import com.faristol.minimalmathalarm.data.model.enums.ProblemType
import com.faristol.minimalmathalarm.data.model.enums.TargetDays

data class Alarm(
    val id: Int,
    val alarmTime: String,
    val alarmProblemDifficulty: ProblemDifficulty,
    val alarmProblemQuantity: Int,
    val alarmProblemType: ProblemType,
    val alarmTargetDays: List<TargetDays>,
    val alarmIsActive: Boolean,
    val alarmVibrate : Boolean,
    val alarmAudioUri : String,
)



