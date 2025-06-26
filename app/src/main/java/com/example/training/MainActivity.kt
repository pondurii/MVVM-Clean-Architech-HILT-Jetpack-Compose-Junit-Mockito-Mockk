package com.example.training

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.training.presentation.screens.AppNavHost
import com.example.training.presentation.screens.MainAppScreen
import com.example.training.ui.theme.MVVMCleanArchitechHILTJetpackComposeJunitMockitoMockkTheme

class MainActivity : ComponentActivity() {
    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MVVMCleanArchitechHILTJetpackComposeJunitMockitoMockkTheme {

                MainAppScreen()
                /*Scaffold(
                    modifier = Modifier.fillMaxSize(),
                    topBar = {
                        TopAppBar(
                            title = {
                                Text("Demo")
                            }
                        )
                    },
                    content = { innerPadding ->
                        AppNavHost(innerPadding, modifier = Modifier.fillMaxSize())
                    },
                    bottomBar = {

                        BottomAppBar(
                            containerColor = MaterialTheme.colorScheme.primaryContainer,
                            contentColor = MaterialTheme.colorScheme.primary,
                        ) {
                            IconButton(onClick = { *//* Handle Home click *//* }) {
                                Icon(Icons.Filled.Home, contentDescription = "Go Home")
                            }
                            Spacer(
                                Modifier.weight(
                                    1f,
                                    true
                                )
                            ) // Pushes subsequent items to the end or middle
                            IconButton(onClick = { *//* Handle Favorite click *//* }) {
                                Icon(Icons.Filled.Favorite, contentDescription = "Favorites")
                            }
                            Spacer(Modifier.weight(1f, true))
                            IconButton(onClick = { *//* Handle Settings click *//* }) {
                                Icon(Icons.Filled.Settings, contentDescription = "Settings")
                            }
                        }
                    }
                )*/
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    MVVMCleanArchitechHILTJetpackComposeJunitMockitoMockkTheme {
        Greeting("Android")
    }
}