package com.example.riyadal_qulub.ui.navigation

import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemColors
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.painterResource
import androidx.navigation.NavBackStackEntry
import androidx.navigation.NavController
import com.example.riyadal_qulub.R
import com.example.riyadal_qulub.ui.theme.Secondary
import com.example.riyadal_qulub.ui.theme.rubikSansFamily


@Composable
fun NavBar(backStackEntry: NavBackStackEntry?, navController: NavController) {
    NavigationBar(
        containerColor = Secondary
    ) {


        NavigationBarItem(

            selected = backStackEntry?.destination?.route == Screen.HomeScreen.route,
            onClick = { navController.navigate(Screen.HomeScreen.route) },
            icon = {
                Icon(
                    painter = painterResource(id = R.drawable.ic_home),
                    contentDescription = "Home icon"
                )
            },
            label = {
                Text(text = "الرئيسية", fontFamily = rubikSansFamily)
            }
        )
        NavigationBarItem(
            selected = backStackEntry?.destination?.route == Screen.StatisticsScreen.route,
            onClick = { navController.navigate(Screen.StatisticsScreen.route) },
            icon = {
                Icon(
                    painter = painterResource(id = R.drawable.ic_statistics),
                    contentDescription = "statistics icon"
                )
            },
            label = {
                Text(text = "الإحصائيات", fontFamily = rubikSansFamily)
            }
        )
        NavigationBarItem(
            selected = backStackEntry?.destination?.route == Screen.SettingsScreen.route,
            onClick = { navController.navigate(Screen.SettingsScreen.route) },
            icon = {
                Icon(
                    painter = painterResource(id = R.drawable.ic_setting),
                    contentDescription = "setting"
                )
            },
            label = {
                Text(text = "الإعدادات", fontFamily = rubikSansFamily)
            }
        )

    }
}