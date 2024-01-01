package com.example.riyadal_qulub.ui.navigation

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import androidx.navigation.NavHostController

import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.riyadal_qulub.ui.screens.addingWirdScreen.AddWirdScreen
import com.example.riyadal_qulub.ui.screens.homeScreen.HomeScreen
import com.example.riyadal_qulub.ui.screens.statisticsScreen.StatisticsScreen
import com.example.riyadal_qulub.ui.screens.wirdScreen.WirdScreen

@Composable
fun Navigation(innerPadding: PaddingValues, navController: NavHostController) {

    NavHost(navController = navController, startDestination = Screen.HomeScreen.route) {
        composable(Screen.HomeScreen.route) {
            HomeScreen(navController = navController, padding = innerPadding)
        }
        composable(Screen.AddWirdScreen.route) {
            AddWirdScreen(navController = navController)
        }
        composable(Screen.SettingsScreen.route) {

        }
        composable(Screen.StatisticsScreen.route) {
            StatisticsScreen(navController = navController, padding = innerPadding)
        }
        composable(Screen.WirdScreen.route("{wirdId}")) { backStackEntry ->
            val arguments = backStackEntry.arguments
            val wirdId = arguments?.getString("wirdId")
            if (wirdId != null) {
                WirdScreen(wirdId = wirdId.toInt(), navController = navController)
            }
        }


    }
}