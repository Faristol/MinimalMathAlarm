package com.faristol.minimalmathalarm.ui.screens.alarm_list.components

import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import com.faristol.minimalmathalarm.domain.model.Alarm
import com.faristol.minimalmathalarm.ui.screens.alarm_list.AlarmListViewModel

@Composable
fun DialogDeleteAlarm(alarm: Alarm, viewModel: AlarmListViewModel,onDismiss: () -> Unit){
    AlertDialog( // 3
        onDismissRequest = { // 4
            onDismiss()
        },
        // 5
        title = { Text(text = "Alert Dialog") },
        text = { Text(text = "Jetpack Compose Alert Dialog") },
        confirmButton = { // 6
            Button(
                onClick = {
                    onDismiss()
                }
            ) {
                Text(
                    text = "Confirm",
                )
            }
        }
    )

}