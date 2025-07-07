package com.example.training

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.example.training.presentation.screens.MainAppScreen
import com.example.training.ui.theme.MVVMCleanArchitechHILTJetpackComposeJunitMockitoMockkTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MVVMCleanArchitechHILTJetpackComposeJunitMockitoMockkTheme {
                MainAppScreen()
            }
        }
    }

}