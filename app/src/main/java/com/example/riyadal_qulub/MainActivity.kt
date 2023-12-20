package com.example.riyadal_qulub

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.riyadal_qulub.ui.navigation.NavBar
import com.example.riyadal_qulub.ui.navigation.Navigation
import com.example.riyadal_qulub.ui.theme.RiyadAlQulubcomposeTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {

            RiyadAlQulubcomposeTheme {
                val navController = rememberNavController()
                val backStackEntry by navController.currentBackStackEntryAsState()
                val showBottomBar by rememberSaveable { mutableStateOf(true) }

                Scaffold(
                    bottomBar = {
                        if (showBottomBar) {
                            NavBar(backStackEntry = backStackEntry, navController = navController)
                        }
                    }
                ) { innerPadding ->
                    Navigation(innerPadding, navController = navController)
                }
            }
        }


    }
}

