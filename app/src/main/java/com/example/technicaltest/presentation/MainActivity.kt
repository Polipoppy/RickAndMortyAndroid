package com.example.technicaltest.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.technicaltest.presentation.character_list.CharacterDetailScreen
import com.example.technicaltest.presentation.character_list.CharacterListScreen
import com.example.technicaltest.presentation.ui.theme.TechnicalTestTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TechnicalTestTheme {
                Surface(color = MaterialTheme.colors.background) {
                    val navController = rememberNavController()
                    NavHost(
                        navController = navController,
                        startDestination = Screen.CharacterListScreen.route
                    ) {
                        composable(
                            route = Screen.CharacterListScreen.route
                        ) {
                            CharacterListScreen(navController)
                        }
                        composable(
                            route = Screen.CharacterDetailScreen.route + "/{characterId}"
                        ) {
                            CharacterDetailScreen()
                        }
                    }
                }
            }
        }
    }
}