package com.faristol.minimalmathalarm.ui.screens.alarm_list

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.TextUnitType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.faristol.minimalmathalarm.R
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
        Column(
            modifier = Modifier
                .padding(innerPadding),
            verticalArrangement = Arrangement.spacedBy(16.dp),
        ) {
            Text(
                modifier = Modifier.padding(8.dp),
                text =
                """
                    This is an example of a scaffold. It uses the Scaffold composable's parameters to create a screen with a simple top app bar, bottom app bar, and floating action button.

                    It also contains some basic inner content, such as this text.

                    You have pressed the floating action button times.
                """.trimIndent(),
            )
        }

    }

}


