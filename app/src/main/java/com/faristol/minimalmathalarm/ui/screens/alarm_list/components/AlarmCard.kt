package com.faristol.minimalmathalarm.ui.screens.alarm_list.components

import android.util.Log
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.combinedClickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedCard
import androidx.compose.material3.Switch
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.faristol.minimalmathalarm.data.model.enums.toFriendlyName
import com.faristol.minimalmathalarm.domain.model.Alarm
import com.faristol.minimalmathalarm.ui.screens.alarm_list.AlarmListViewModel

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun AlarmCard(alarm: Alarm, viewModel: AlarmListViewModel) {
    var showDeleteDialog by remember { mutableStateOf(false) }
    OutlinedCard(
        modifier = Modifier
            .combinedClickable(onClick = {}, onLongClick = {
                showDeleteDialog = true
            })
            .fillMaxWidth()
            .padding(vertical = 8.dp),
        border = BorderStroke(1.dp, MaterialTheme.colorScheme.secondary)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Column(
                modifier = Modifier.weight(1f)
            ) {
                Text(
                    text = alarm.alarmTime,
                    style = MaterialTheme.typography.displayMedium
                )
                Row(

                    modifier = Modifier.padding(top = 4.dp),
                    horizontalArrangement = Arrangement.Start
                ) {
                    alarm.alarmTargetDays.forEach { day ->

                        Text(

                            text = day.toFriendlyName(),
                            style = MaterialTheme.typography.bodySmall,
                            modifier = Modifier.padding(horizontal = 4.dp)
                        )


                    }
                }
            }
            Column(
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Switch(
                    checked = alarm.alarmIsActive,
                    onCheckedChange = { isChecked ->
                        val updatedAlarm = alarm.copy(alarmIsActive = isChecked)
                        viewModel.insertUpdateAlarm(updatedAlarm)
                    }
                )
            }
        }
    }
    if(showDeleteDialog){
        DialogDeleteAlarm(alarm = alarm, viewModel = viewModel,onDismiss = { showDeleteDialog = false })

    }
}
