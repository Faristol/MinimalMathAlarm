package com.faristol.minimalmathalarm.ui.nav

import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.ViewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.faristol.minimalmathalarm.ui.screens.alarm_detail.AlarmDetailScreen
import com.faristol.minimalmathalarm.ui.screens.alarm_list.AlarmListScreen
import com.faristol.minimalmathalarm.ui.screens.alarm_list.AlarmListViewModel


@Composable
fun NavigationWrapper(alarmListViewModel: AlarmListViewModel) {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = AlarmList) {
        composable<AlarmList> {
            AlarmListScreen(
                onNavigateToDetail = { navController.navigate(AlarmDetail) },
                viewModel = alarmListViewModel
            )
        }
        composable<AlarmDetail> {
            AlarmDetailScreen { navController.navigate(AlarmList) }
        }
    }

}