package com.faristol.minimalmathalarm.ui.screens.alarm_list

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.faristol.minimalmathalarm.ui.screens.alarm_list.components.AlarmCard
import com.faristol.minimalmathalarm.ui.screens.alarm_list.components.AlarmListFloatingActionButton
import com.faristol.minimalmathalarm.ui.screens.alarm_list.components.AlarmListTopBar

@Composable
fun AlarmListScreen(
    onNavigateToDetail: () -> Unit,
    viewModel: AlarmListViewModel
) {

    val uiState by viewModel.uiState.collectAsState()
    Scaffold(

        topBar = {
            AlarmListTopBar(viewModel, uiState)

        },
        floatingActionButton = {
            AlarmListFloatingActionButton(viewModel)
        }
    ) { innerPadding ->
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
                .padding(16.dp)
        ) {
            LazyColumn {
                items(uiState.alarmList) { alarm ->
                    AlarmCard(alarm, viewModel)
                }
            }
        }

    }

}



