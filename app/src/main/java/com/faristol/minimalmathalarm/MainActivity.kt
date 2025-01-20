package com.faristol.minimalmathalarm

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.hilt.navigation.compose.hiltViewModel
import com.faristol.minimalmathalarm.ui.nav.NavigationWrapper
import com.faristol.minimalmathalarm.ui.screens.alarm_list.AlarmListScreen
import com.faristol.minimalmathalarm.ui.screens.alarm_list.AlarmListViewModel
import com.faristol.minimalmathalarm.ui.theme.MinimalMathAlarmTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            val alarmListViewModel: AlarmListViewModel = hiltViewModel()
            val uiState by alarmListViewModel.uiState.collectAsState()
            MinimalMathAlarmTheme(darkTheme = uiState.isDarkMode) {
                NavigationWrapper(alarmListViewModel)
            }
        }
    }
}
//    @Composable
//    fun MinimalMathAlarmLayout() {
//        var isDarkTheme by remember { mutableStateOf(false) }
//        val cardItems = remember { mutableStateListOf<CardInfo>() }
//        MinimalMathAlarmTheme(darkTheme = isDarkTheme) {
//            Scaffold(topBar = {
//                MinimalMathAlarmTopBar(
//                    isDarkTheme,
//                    onThemeChange = { isDarkTheme = it })
//
//            },
//                floatingActionButton = {
//                    FloatingActionButton(onClick = { cardItems.add(CardInfo()) }) {
//                        Icon(Icons.Default.Add, contentDescription = "Add")
//                    }
//                }
//
//            ) { paddingValues ->
//                LazyColumn(
//                    modifier = Modifier.padding(paddingValues)
//                ) {
//                    itemsIndexed(cardItems) { _, card ->
//                        Card(
//                            modifier = Modifier.fillMaxWidth().padding(10.dp)
//                        ) {
//                            Row{
//                                Column {
//                                    Text("Ie que passa")
//                                }
//                                Column{
//                                    Text("Ie que passa")
//
//                                }
//                            }
//                            Row{
//                                Text("Ie que passa")
//                            }
//                        }
//                    }
//
//
//                }
//            }
//        }
//    }
//
//    class MainActivity : ComponentActivity() {
//        override fun onCreate(savedInstanceState: Bundle?) {
//            super.onCreate(savedInstanceState)
//            enableEdgeToEdge()
//            setContent {
//                MinimalMathAlarmLayout()
//
//            }
//        }
//
//        @Composable
//        fun MinimalMathAlarmLayout() {
//            var isDarkTheme by remember { mutableStateOf(false) }
//            val cardItems = remember { mutableStateListOf<CardInfo>() }
//            MinimalMathAlarmTheme(darkTheme = isDarkTheme) {
//                Scaffold(topBar = {
//                    MinimalMathAlarmTopBar(
//                        isDarkTheme,
//                        onThemeChange = { isDarkTheme = it })
//
//                },
//                    floatingActionButton = {
//                        FloatingActionButton(onClick = { cardItems.add(CardInfo()) }) {
//                            Icon(Icons.Default.Add, contentDescription = "Add")
//                        }
//                    }
//
//                ) { paddingValues ->
//                    LazyColumn(
//                        modifier = Modifier.padding(paddingValues)
//                    ) {
//                        itemsIndexed(cardItems) { index, card ->
//                            // Mostrar cada tarjeta en la lista
//                            Card(
//                                modifier = Modifier.padding(8.dp)
//                            ) {
//                                Text(text = "Card Info: ${card.toString()}") // Ajusta esto según las propiedades de `CardInfo`
//                            }
//                        }
//
//
//                    }
//                }
//            }
//        }
//
//
//        @OptIn(ExperimentalMaterial3Api::class)
//        @Composable
//        fun MinimalMathAlarmTopBar(isDarkTheme: Boolean, onThemeChange: (Boolean) -> Unit) {
//
//            TopAppBar(
//                title = {
//                    Text(
//                        text = "Minimal Math Alarm",
//                        fontWeight = FontWeight.SemiBold,
//                        fontSize = 20.sp,
//                        letterSpacing = TextUnit(2F, TextUnitType.Sp)
//                    )
//                },
//                actions = {
//                    GitHubImage()
//                    IconButton(
//                        onClick = { onThemeChange(!isDarkTheme) } // Cambia entre temas
//                    ) {
//                        val iconRes =
//                            if (isDarkTheme) R.drawable.baseline_wb_sunny_24 else R.drawable.baseline_dark_mode_24
//                        Icon(
//                            painter = painterResource(id = iconRes),
//                            contentDescription = "Cambiar tema"
//                        )
//                    }
//
//                }
//            )
//        }
//
//
//        @Composable
//        fun GitHubImage() {
//            val context = LocalContext.current
//            IconButton(onClick = {
//                val intent =
//                    Intent(Intent.ACTION_VIEW, Uri.parse("https://github.com/Faristol"))
//                context.startActivity(intent) // Abre el navegador con la URL
//            }) {
//                Icon(
//                    imageVector = Github, // Cambia por el recurso del ícono que desees usar
//                    contentDescription = "Go to GitHub"
//                )
//            }
//        }
//
//
//    }
//
//
//    @OptIn(ExperimentalMaterial3Api::class)
//    @Composable
//    fun MinimalMathAlarmTopBar(isDarkTheme: Boolean, onThemeChange: (Boolean) -> Unit) {
//
//        TopAppBar(
//            title = {
//                Text(
//                    text = "Minimal Math Alarm",
//                    fontWeight = FontWeight.SemiBold,
//                    fontSize = 20.sp,
//                    letterSpacing = TextUnit(2F, TextUnitType.Sp)
//                )
//            },
//            actions = {
//                GitHubImage()
//                IconButton(
//                    onClick = { onThemeChange(!isDarkTheme) } // Cambia entre temas
//                ) {
//                    val iconRes =
//                        if (isDarkTheme) R.drawable.baseline_wb_sunny_24 else R.drawable.baseline_dark_mode_24
//                    Icon(
//                        painter = painterResource(id = iconRes),
//                        contentDescription = "Cambiar tema"
//                    )
//                }
//
//            }
//        )
//    }
//
//
//    @Composable
//    fun GitHubImage() {
//        val context = LocalContext.current
//        IconButton(onClick = {
//            val intent =
//                Intent(Intent.ACTION_VIEW, Uri.parse("https://github.com/Faristol"))
//            context.startActivity(intent) // Abre el navegador con la URL
//        }) {
//            Icon(
//                imageVector = Github, // Cambia por el recurso del ícono que desees usar
//                contentDescription = "Go to GitHub"
//            )
//        }
//    }
//



