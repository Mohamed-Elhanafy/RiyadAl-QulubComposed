package com.example.riyadal_qulub.ui.navigation

import android.content.Context
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
import com.example.riyadal_qulub.ui.screens.onBoarding.OnBoardingScreen
import com.example.riyadal_qulub.ui.screens.statisticsScreen.StatisticsScreen
import com.example.riyadal_qulub.ui.screens.wirdScreen.WirdScreen

@Composable
fun Navigation(innerPadding: PaddingValues, navController: NavHostController,context: Context) {

    val sharedPreferences = context.getSharedPreferences("MyApp", Context.MODE_PRIVATE)
    val hasSeenOnboarding = sharedPreferences.getBoolean("hasSeenOnboarding", false)
    val startDestination = if (hasSeenOnboarding) Screen.HomeScreen.route else Screen.OnBoardingScreen.route

    NavHost(navController = navController, startDestination = startDestination) {
        composable(Screen.OnBoardingScreen.route) {
            OnBoardingScreen(navController = navController , context = context)
        }
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