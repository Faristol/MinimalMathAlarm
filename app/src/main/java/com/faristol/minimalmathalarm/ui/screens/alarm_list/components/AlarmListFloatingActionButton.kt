package com.faristol.minimalmathalarm.ui.screens.alarm_list.components

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import com.faristol.minimalmathalarm.data.model.enums.ProblemDifficulty
import com.faristol.minimalmathalarm.data.model.enums.ProblemType
import com.faristol.minimalmathalarm.data.model.enums.TargetDays
import com.faristol.minimalmathalarm.domain.model.Alarm
import com.faristol.minimalmathalarm.ui.screens.alarm_list.AlarmListViewModel

@Composable
fun AlarmListFloatingActionButton(viewModel: AlarmListViewModel){
    FloatingActionButton(onClick = {viewModel.insertUpdateAlarm(defaultAlarm())}) {
        Icon(Icons.Default.Add, contentDescription = "Add")
    }
}

fun defaultAlarm(): Alarm{
    return Alarm(
        alarmTime = "07:00",
        alarmProblemDifficulty = ProblemDifficulty.EASY,
        alarmProblemQuantity = 5,
        alarmProblemType = listOf(ProblemType.SUM),
        alarmTargetDays = listOf(TargetDays.MONDAY,TargetDays.TUESDAY,TargetDays.WEDNESDAY,TargetDays.THURSDAY,TargetDays.FRIDAY,TargetDays.SATURDAY,TargetDays.SUNDAY),
        alarmIsActive = true,
        alarmVibrate = false,
        alarmAudioUri = "",
    )
}
