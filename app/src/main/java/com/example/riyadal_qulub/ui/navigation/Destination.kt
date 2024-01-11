package com.example.riyadal_qulub.ui.navigation

import androidx.navigation.NamedNavArgument

sealed class Screen(val route: String) {
    data object OnBoardingScreen : Screen("on_boarding_screen")
    data object HomeScreen : Screen("home_screen")
    data object AddWirdScreen : Screen("add_wird_screen")
    data object WirdDetailScreen : Screen("wird_detail_screen")

    data object SettingsScreen : Screen("settings_screen")

    data object StatisticsScreen : Screen("statistics_screen")

    data object SignInScreen : Screen("sign_in_screen")

    data object SignUpScreen : Screen("sign_up_screen")
    data object WirdScreen : Screen("wird_screen/{wirdId}") {
        fun route(wirdId: String) = "wird_screen/$wirdId"
    }
}

