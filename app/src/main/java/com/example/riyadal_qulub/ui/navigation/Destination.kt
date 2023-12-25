package com.example.riyadal_qulub.ui.navigation

import androidx.navigation.NamedNavArgument

sealed class Screen(val route : String){
    object HomeScreen : Screen("home_screen")
    object AddWirdScreen : Screen("add_wird_screen")
    object WirdDetailScreen : Screen("wird_detail_screen")

    object SettingsScreen : Screen("settings_screen")

    object StatisticsScreen : Screen("statistics_screen")

    object WirdScreen : Screen("wird_screen")

    fun createRoute(args : List<NamedNavArgument> = emptyList()) : String{
        return buildString {
            append(route)
            args.forEach { arg ->
                append("/${arg.name}")
            }
        }
    }
}

