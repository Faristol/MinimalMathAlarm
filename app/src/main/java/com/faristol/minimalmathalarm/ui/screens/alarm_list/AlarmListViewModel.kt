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
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class AlarmListViewModel @Inject constructor(
    private val insertAlarmUseCase: InsertAlarmUseCase,
    private val deleteAlarmUseCase: DeleteAlarmUseCase,
    private val getAllAlarmsUseCase: GetAllAlarmsUseCase,
    private val getAlarmByIdUseCase: GetAlarmByIdUseCase
) : ViewModel() {

    private val _uiState = MutableStateFlow(AlarmListState())
    val uiState: StateFlow<AlarmListState> =  _uiState.asStateFlow()

    fun getAlarmList(){
        viewModelScope.launch {
            getAllAlarmsUseCase().collect { alarms ->
                _uiState.update { currentState ->
                    currentState.copy(alarmList = alarms)
                }
            }
        }
    }

    fun setDarkMode(isDarkMode: Boolean) {
        _uiState.update { currentState ->
            currentState.copy(
                isDarkMode = isDarkMode
            )
        }
    }

    fun insertUpdateAlarm(alarm: Alarm){
        viewModelScope.launch {
            insertAlarmUseCase(alarm)
        }







    }



    // events -> insert alarm, delete delete, open alarm, update alarm (only active or no)
    //open github project, and change the theme (dark mode)





















}