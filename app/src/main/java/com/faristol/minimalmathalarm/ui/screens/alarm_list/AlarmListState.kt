package com.faristol.minimalmathalarm.ui.screens.alarm_list

import com.faristol.minimalmathalarm.domain.model.Alarm
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.emptyFlow


//esta classe es inmutable treballarem amb copy
//ací sols posarem els events o allò que volem que mantinga el estat,
//que siga persistent, events com el de polsar sobre el + per a afegir
//una alarma no els tindre ací
data class AlarmListState(
    val alarmList: List<Alarm> = emptyList(),
    val isDarkMode:  Boolean =   true,
)












