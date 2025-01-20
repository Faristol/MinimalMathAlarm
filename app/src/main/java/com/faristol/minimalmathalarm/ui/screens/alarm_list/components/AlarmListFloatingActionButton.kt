package com.faristol.minimalmathalarm.ui.screens.alarm_list.components

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import com.faristol.minimalmathalarm.ui.screens.alarm_list.AlarmListViewModel

@Composable
fun AlarmListFloatingActionButton(viewModel: AlarmListViewModel){
    FloatingActionButton(onClick = {}) {
        Icon(Icons.Default.Add, contentDescription = "Add")
    }
}