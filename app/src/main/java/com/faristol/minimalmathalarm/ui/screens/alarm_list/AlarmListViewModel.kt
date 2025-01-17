package com.faristol.minimalmathalarm.ui.screens.alarm_list

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.faristol.minimalmathalarm.domain.model.Alarm
import com.faristol.minimalmathalarm.domain.usecase.DeleteAlarmUseCase
import com.faristol.minimalmathalarm.domain.usecase.GetAlarmByIdUseCase
import com.faristol.minimalmathalarm.domain.usecase.GetAllAlarmsUseCase
import com.faristol.minimalmathalarm.domain.usecase.InsertAlarmUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class AlarmListViewModel @Inject constructor(
    private val insertAlarmUseCase: InsertAlarmUseCase,
    private val deleteAlarmUseCase: DeleteAlarmUseCase,
    private val getAllAlarmsUseCase: GetAllAlarmsUseCase,
    private val getAlarmByIdUseCase: GetAlarmByIdUseCase
) : ViewModel() {

    private val _alarmsList = MutableStateFlow<List<Alarm>>(emptyList())
    val alarmsList: StateFlow<List<Alarm>> =  _alarmsList

    private val _uiEvent = Channel<UiEvent>()


    fun getAlarmsList(){
        viewModelScope.launch {
            getAllAlarmsUseCase().collect{ alarm ->
                _alarmsList.value = alarm
            }
        }
    }


    // events -> insert alarm, delete delete, open alarm, update alarm (only active or no)
    //open github project, and change the theme (dark mode)





















}