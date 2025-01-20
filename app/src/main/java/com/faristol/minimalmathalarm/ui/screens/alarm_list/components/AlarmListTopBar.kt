package com.faristol.minimalmathalarm.ui.screens.alarm_list.components

import android.content.Intent
import android.net.Uri
import android.util.Log
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.TextUnitType
import androidx.compose.ui.unit.sp
import com.faristol.minimalmathalarm.R
import com.faristol.minimalmathalarm.ui.screens.alarm_list.AlarmListState
import com.faristol.minimalmathalarm.ui.screens.alarm_list.AlarmListViewModel
import drawable.Github

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AlarmListTopBar(viewModel: AlarmListViewModel, uiState: AlarmListState) {
    TopAppBar(
        title = {
            Text(
                text = "Minimal Math Alarm",
                fontWeight = FontWeight.SemiBold,
                fontSize = 20.sp,
                letterSpacing = TextUnit(2F, TextUnitType.Sp)
            )
        },
        actions = {
            OpenGitHubButton()
            IconButton(
                onClick = { viewModel.toggleDarkMode() }
            ) {
                val iconRes =
                    if (uiState.isDarkMode) R.drawable.baseline_wb_sunny_24 else R.drawable.baseline_dark_mode_24
                Icon(
                    painter = painterResource(id = iconRes),
                    contentDescription = "Cambiar tema"
                )
            }

        }
    )

}

@Composable
fun OpenGitHubButton() {
    val context = LocalContext.current
    IconButton(onClick = {
        val githubUrl = "https://github.com/faristol/minimalmathalarm"
        val intent = Intent(Intent.ACTION_VIEW, Uri.parse(githubUrl))
        intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK

        // Verifica si hay alguna app que pueda manejar el Intent
        if (intent.resolveActivity(context.packageManager) != null) {
            context.startActivity(intent) // Abre la URL en una app que maneje el Intent
        } else {
            try {
                // Si no hay app, intenta abrir el navegador predeterminado
                context.startActivity(intent) // Abre en el navegador predeterminado
            } catch (e: Exception) {
                Log.d("GitHubLauncher", "No se pudo abrir la URL en el navegador", e)
            }
        }
    }) {
        Icon(
            imageVector = Github,
            contentDescription = "Go to GitHub"
        )
    }
}