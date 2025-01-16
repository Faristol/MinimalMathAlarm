package com.faristol.minimalmathalarm

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.TextUnitType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.faristol.minimalmathalarm.presentation.theme.MinimalMathAlarmTheme
import drawable.Github


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MinimalMathAlarmLayout()

        }
    }

    @Composable
    fun MinimalMathAlarmLayout() {
        var isDarkTheme by remember { mutableStateOf(false) }
        val cardItems = remember { mutableStateListOf<CardInfo>() }
        MinimalMathAlarmTheme(darkTheme = isDarkTheme) {
            Scaffold(topBar = {
                MinimalMathAlarmTopBar(
                    isDarkTheme,
                    onThemeChange = { isDarkTheme = it })

            },
                floatingActionButton = {
                    FloatingActionButton(onClick = { cardItems.add(CardInfo()) }) {
                        Icon(Icons.Default.Add, contentDescription = "Add")
                    }
                }

            ) { paddingValues ->
                LazyColumn(
                    modifier = Modifier.padding(paddingValues)
                ) {
                    itemsIndexed(cardItems) { _, card ->
                        Card(
                            modifier = Modifier.fillMaxWidth().padding(10.dp)
                        ) {
                            Row{
                                Column {
                                    Text("Ie que passa")
                                }
                                Column{
                                    Text("Ie que passa")

                                }
                            }
                            Row{
                                Text("Ie que passa")
                            }
                        }
                    }


                }
            }
        }
    }

    class MainActivity : ComponentActivity() {
        override fun onCreate(savedInstanceState: Bundle?) {
            super.onCreate(savedInstanceState)
            enableEdgeToEdge()
            setContent {
                MinimalMathAlarmLayout()

            }
        }

        @Composable
        fun MinimalMathAlarmLayout() {
            var isDarkTheme by remember { mutableStateOf(false) }
            val cardItems = remember { mutableStateListOf<CardInfo>() }
            MinimalMathAlarmTheme(darkTheme = isDarkTheme) {
                Scaffold(topBar = {
                    MinimalMathAlarmTopBar(
                        isDarkTheme,
                        onThemeChange = { isDarkTheme = it })

                },
                    floatingActionButton = {
                        FloatingActionButton(onClick = { cardItems.add(CardInfo()) }) {
                            Icon(Icons.Default.Add, contentDescription = "Add")
                        }
                    }

                ) { paddingValues ->
                    LazyColumn(
                        modifier = Modifier.padding(paddingValues)
                    ) {
                        itemsIndexed(cardItems) { index, card ->
                            // Mostrar cada tarjeta en la lista
                            Card(
                                modifier = Modifier.padding(8.dp)
                            ) {
                                Text(text = "Card Info: ${card.toString()}") // Ajusta esto según las propiedades de `CardInfo`
                            }
                        }


                    }
                }
            }
        }


        @OptIn(ExperimentalMaterial3Api::class)
        @Composable
        fun MinimalMathAlarmTopBar(isDarkTheme: Boolean, onThemeChange: (Boolean) -> Unit) {

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
                    GitHubImage()
                    IconButton(
                        onClick = { onThemeChange(!isDarkTheme) } // Cambia entre temas
                    ) {
                        val iconRes =
                            if (isDarkTheme) R.drawable.baseline_wb_sunny_24 else R.drawable.baseline_dark_mode_24
                        Icon(
                            painter = painterResource(id = iconRes),
                            contentDescription = "Cambiar tema"
                        )
                    }

                }
            )
        }


        @Composable
        fun GitHubImage() {
            val context = LocalContext.current
            IconButton(onClick = {
                val intent =
                    Intent(Intent.ACTION_VIEW, Uri.parse("https://github.com/Faristol"))
                context.startActivity(intent) // Abre el navegador con la URL
            }) {
                Icon(
                    imageVector = Github, // Cambia por el recurso del ícono que desees usar
                    contentDescription = "Go to GitHub"
                )
            }
        }


    }


    @OptIn(ExperimentalMaterial3Api::class)
    @Composable
    fun MinimalMathAlarmTopBar(isDarkTheme: Boolean, onThemeChange: (Boolean) -> Unit) {

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
                GitHubImage()
                IconButton(
                    onClick = { onThemeChange(!isDarkTheme) } // Cambia entre temas
                ) {
                    val iconRes =
                        if (isDarkTheme) R.drawable.baseline_wb_sunny_24 else R.drawable.baseline_dark_mode_24
                    Icon(
                        painter = painterResource(id = iconRes),
                        contentDescription = "Cambiar tema"
                    )
                }

            }
        )
    }


    @Composable
    fun GitHubImage() {
        val context = LocalContext.current
        IconButton(onClick = {
            val intent =
                Intent(Intent.ACTION_VIEW, Uri.parse("https://github.com/Faristol"))
            context.startActivity(intent) // Abre el navegador con la URL
        }) {
            Icon(
                imageVector = Github, // Cambia por el recurso del ícono que desees usar
                contentDescription = "Go to GitHub"
            )
        }
    }


}

