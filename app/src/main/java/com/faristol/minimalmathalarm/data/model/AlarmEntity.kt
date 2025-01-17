package com.faristol.minimalmathalarm.data.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.faristol.minimalmathalarm.data.model.enums.ProblemDifficulty
import com.faristol.minimalmathalarm.data.model.enums.ProblemType
import com.faristol.minimalmathalarm.data.model.enums.TargetDays


@Entity
data class AlarmEntity(
    @PrimaryKey(autoGenerate = true)
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