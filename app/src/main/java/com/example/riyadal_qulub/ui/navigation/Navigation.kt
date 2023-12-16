package com.example.riyadal_qulub.ui.navigation

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.riyadal_qulub.ui.addingWirdScreen.AddWirdScreen
import com.example.riyadal_qulub.ui.homeScreen.HomeScreen

@Composable
fun Navigation(innerPadding: PaddingValues) {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = Screen.HomeScreen.route) {
        composable(Screen.HomeScreen.route) {
            Surface(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(),
                color = MaterialTheme.colorScheme.background
            ) {
                HomeScreen( navController = navController)
            }
        }
        composable(Screen.AddWirdScreen.route) {
            Surface(
                modifier = Modifier
                    .fillMaxSize()
                   ,
                color = MaterialTheme.colorScheme.background
            ) {
                AddWirdScreen( navController = navController)
            }
        }
    }

}