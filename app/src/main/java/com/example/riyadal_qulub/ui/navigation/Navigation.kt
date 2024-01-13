package com.example.riyadal_qulub.ui.navigation

import android.content.Context
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController

import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.riyadal_qulub.ui.screens.addingWirdScreen.AddWirdScreen
import com.example.riyadal_qulub.ui.screens.authenticate.signin.SignInScreen
import com.example.riyadal_qulub.ui.screens.authenticate.signup.SignUpScreen
import com.example.riyadal_qulub.ui.screens.homeScreen.HomeScreen
import com.example.riyadal_qulub.ui.screens.onBoarding.OnBoardingScreen
import com.example.riyadal_qulub.ui.screens.settings.SettingsScreen
import com.example.riyadal_qulub.ui.screens.statisticsScreen.StatisticsScreen
import com.example.riyadal_qulub.ui.screens.wirdScreen.WirdScreen

@Composable
fun Navigation(innerPadding: PaddingValues, navController: NavHostController, context: Context) {

    val sharedPreferences = context.getSharedPreferences("MyApp", Context.MODE_PRIVATE)
    val hasSeenOnboarding = sharedPreferences.getBoolean("hasSeenOnboarding", false)
    val hasSignedIn = sharedPreferences.getBoolean("hasSignedIn", false)

    val startDestination =
        when {
            !hasSeenOnboarding -> Screen.OnBoardingScreen.route
            !hasSignedIn -> Screen.SignInScreen.route
            else -> Screen.HomeScreen.route
        }
    NavHost(navController = navController, startDestination = startDestination) {
        composable(Screen.OnBoardingScreen.route) {
            OnBoardingScreen(navController = navController, context = context)
        }

        composable(Screen.HomeScreen.route) {
            HomeScreen(navController = navController, padding = innerPadding)
        }
        composable(Screen.AddWirdScreen.route) {
            AddWirdScreen(navController = navController)
        }
        composable(Screen.SettingsScreen.route) {
            SettingsScreen(context = context)
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

        composable(Screen.SignInScreen.route) {
            SignInScreen(navController = navController, context = context)
        }

        composable(Screen.SignUpScreen.route) {
            SignUpScreen(navController = navController , context = context)
        }


    }
}