package com.example.riyadal_qulub

import android.content.pm.PackageManager
import android.os.Build
import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.compose.setContent
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.core.content.ContextCompat
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.riyadal_qulub.notification.CounterNotificationService
import com.example.riyadal_qulub.ui.navigation.NavBar
import com.example.riyadal_qulub.ui.navigation.Navigation
import com.example.riyadal_qulub.ui.navigation.Screen
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
                var showBottomBar by rememberSaveable { mutableStateOf(true) }

                //to hide bottom bar in onboarding screen
                showBottomBar = when (backStackEntry?.destination?.route) {
                    Screen.OnBoardingScreen.route -> false
                    Screen.SignInScreen.route -> false
                    Screen.SignUpScreen.route -> false
                    else -> true
                }

                Scaffold(
                    bottomBar = {
                        if (showBottomBar) {
                            NavBar(backStackEntry = backStackEntry, navController = navController)
                        }
                    }
                ) { innerPadding ->
                    Navigation(innerPadding, navController = navController, context = this)
                }
            }




            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
                requestPermissions(
                    arrayOf(
                        android.Manifest.permission.POST_NOTIFICATIONS,
                    ), 99
                )
            }


        }


    }

    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
    ) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        if (requestCode == 99) {
            if (grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                //granted
                Log.i("Main", "onRequestPermissionsResult: Granted")
            } else {
                //not granted
            }
        }
    }
}

